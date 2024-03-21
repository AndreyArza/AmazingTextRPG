package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Game
import kotlinx.serialization.Serializable


@Serializable
data class GameData(
    val allActions: List<ActionData>,
    val allStates: List<StateData>,
    val allLocations: List<LocationData>,
    val allDirections: List<DirectionData>,
    val allStats: List<StatData>,
    val allStatsValues: List<StatValueData>,
    val initModel: ModelData
) {
    fun transform() =
        Game(
            allActions = allActions.map { it.transform() }.associateBy { it.id },
            allStates = allStates.map { it.transform(allActions) }.associateBy { it.id },
            allLocations= allLocations.map { it.transform() }.associateBy { it.id },
            allDirections= allDirections.map { it.transform() }.associateBy { it.id },
            allStats= allStats.map { it.transform(allStatsValues) }.associateBy { it.id },
            allStatsValues = allStatsValues.map { it.transform() }.associateBy { it.id },
            initModel = initModel.transform(allStats, allStatsValues)

        )
}


