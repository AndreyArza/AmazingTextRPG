package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable
import ru.andrey.demotextrpg.logic.data.Game
import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.data.Stat


@Serializable
enum class StatEventTypeData {
    ADD,
    REMOVE,
    UPDATE
}

@Serializable
data class StatEventData(
    val statId: String,
    val statValueId: String,
    val type: StatEventTypeData,
)

@Serializable
data class SideEffectData(
    val newStateId: String? = null,
    val newLocationId: String? = null,
    val statEvents: List<StatEventData> = listOf(),
) {
//    fun transform(): (Game, Model) -> Model {
//        return { game, model ->
//            val newStats = mutableListOf<Stat>()
//            model.info.stats.values.forEach { oldStat ->
//                val newStatsValues =
//                    newStatsValuesIds
//                        .mapNotNull { game.allStatsValues[it] }
//                        .filter { it.statId == oldStat.id }
//                if (newStatsValues.isEmpty()) {
//                    newStats.add(oldStat)
//                } else {
//                    newStats.add(
//                        oldStat.copy(
//                            values = newStatsValues.toMutableSet()
//                        )
//                    )
//                }
//            }
//            addingStatsValuesIds
//                .mapNotNull { game.allStatsValues[it] }
//                .forEach { statValue ->
//                    newStats
//                        .firstOrNull { it.id == statValue.id }
//                        ?.values
//                        ?.add(statValue)
//                }
//            removingStatsValuesIds
//                .mapNotNull { game.allStatsValues[it] }
//                .forEach { statValue ->
//                    newStats
//                        .firstOrNull { it.id == statValue.id }
//                        ?.values
//                        ?.remove(statValue)
//                }
//
//
//            model.copy(
//                locationId = newLocationId ?: model.locationId,
//                stateId = newStateId ?: model.locationId,
//                info = model.info.copy(
//                    stats = newStats.associateBy { it.id },
//                    hiddenFlagsIds = model.info.hiddenFlagsIds.apply {
//                        this.addAll(addingFlagsIds)
//                        this.removeAll(removingFlagsIds.toSet())
//                    }
//                )
//            )
//        }
//    }
}

@Serializable
data class DeprecatedSideEffectData(
    val newStateId: String? = null,
    val newLocationId: String? = null,
    val newStatsValuesIds: List<String> = listOf(),
    val addingStatsValuesIds: List<String> = listOf(),
    val removingStatsValuesIds: List<String> = listOf(),
    val addingFlagsIds: List<String> = listOf(),
    val removingFlagsIds: List<String> = listOf(),
) {
    fun transform(): (Game, Model) -> Model {
        return { game, model ->
            val newStats = mutableListOf<Stat>()
            model.info.stats.values.forEach { oldStat ->
                val newStatsValues =
                    newStatsValuesIds
                        .mapNotNull { game.allStatsValues[it] }
                        .filter { it.statId == oldStat.id }
                if (newStatsValues.isEmpty()) {
                    newStats.add(oldStat)
                } else {
                    newStats.add(
                        oldStat.copy(
                            values = newStatsValues.toMutableSet()
                        )
                    )
                }
            }
            addingStatsValuesIds
                .mapNotNull { game.allStatsValues[it] }
                .forEach { statValue ->
                    newStats
                        .firstOrNull { it.id == statValue.id }
                        ?.values
                        ?.add(statValue)
                }
            removingStatsValuesIds
                .mapNotNull { game.allStatsValues[it] }
                .forEach { statValue ->
                    newStats
                        .firstOrNull { it.id == statValue.id }
                        ?.values
                        ?.remove(statValue)
                }


            model.copy(
                locationId = newLocationId ?: model.locationId,
                stateId = newStateId ?: model.locationId,
                info = model.info.copy(
                    stats = newStats.associateBy { it.id },
                    hiddenFlagsIds = model.info.hiddenFlagsIds.apply {
                        this.addAll(addingFlagsIds)
                        this.removeAll(removingFlagsIds.toSet())
                    }
                )
            )
        }
    }
}

