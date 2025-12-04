package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Game
import kotlinx.serialization.Serializable


@Serializable
data class GameData(
    val id: String,
    val version: String,
    val name: String,
    val locationTabInfo: TabData,
    val stateTabInfo: TabData,
    val statsTabInfo: TabData
)

@Serializable
data class GameData1(
    val allActions: List<ActionData>,
    val allStates: List<StateData>,
    val allLocations: List<LocationData>,
    val allDirections: List<DirectionData>,
    val allStats: List<StatData>,
    val allStatsValues: List<StatValueData>,
    val initModel: ModelData
)

@Serializable
data class DeprecatedGameData(
    val allActions: List<DeprecatedActionData>,
    val allStates: List<DeprecatedStateData>,
    val allLocations: List<LocationData>,
    val allDirections: List<DeprecatedDirectionData>,
    val allStats: List<DeprecatedStatData>,
    val allStatsValues: List<DeprecatedStatValueData>,
    val initModel: DeprecatedModelData
) {
    fun transform() =
        Game(
            allActions = allActions.map { it.transform() }.associateBy { it.id },
            allStates = allStates.map { it.transform(allActions) }.associateBy { it.id },
            allLocations= allLocations.map { it.deprecatedTransform() }.associateBy { it.id },
            allDirections= allDirections.map { it.transform() }.associateBy { it.id },
            allStats= allStats.map { it.transform(allStatsValues) }.associateBy { it.id },
            allStatsValues = allStatsValues.map { it.transform() }.associateBy { it.id },
            initModel = initModel.transform(allStats, allStatsValues)

        )
}


