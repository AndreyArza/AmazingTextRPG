package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Game
import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.Stat
import kotlinx.serialization.Serializable


@Serializable
data class SideEffectData(
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

