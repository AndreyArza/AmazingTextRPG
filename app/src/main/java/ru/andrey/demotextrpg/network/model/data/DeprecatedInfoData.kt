package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Info
import kotlinx.serialization.Serializable

@Serializable
data class DeprecatedInfoData(
    val statsValuesIds: List<String>,
    val hiddenFlagsIds: List<String> = listOf()
) {
    fun transform(allStats: List<DeprecatedStatData>, allStatsValues: List<DeprecatedStatValueData>): Info {
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

