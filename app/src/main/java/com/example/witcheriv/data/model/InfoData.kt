package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Info
import kotlinx.serialization.Serializable

@Serializable
data class InfoData(
    val statsValuesIds: List<String>,
    val hiddenFlagsIds: List<String> = listOf()
) {
    fun transform(allStats: List<StatData>, allStatsValues: List<StatValueData>): Info {
        val usingStatsValues =
            allStatsValues.filter { statValue -> statsValuesIds.firstOrNull { it == statValue.id } != null }
        val stats =
            allStats.filter { stat -> usingStatsValues.firstOrNull { stat.id == it.statId } != null }
                .map { it.transform(allStatsValues) }.associateBy { it.id }.toMutableMap()
        stats.values.forEach{
            it.values.clear()
        }
        usingStatsValues.forEach {
            stats[it.statId]?.values?.add(it.transform())
        }
        return Info(
            stats = stats,
            hiddenFlagsIds = hiddenFlagsIds.toMutableSet()
        )
    }
}

