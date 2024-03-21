package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.logic.data.StatValue
import kotlinx.serialization.Serializable

@Serializable
data class SuccessCheck(
    val requiredStatsValuesIds: List<String> = listOf(),
    val requiredFlagsIds: List<String> = listOf(),
    val unsuccessfulStatsValuesIds: List<String> = listOf(),
    val unsuccessfulFlagsIds: List<String> = listOf(),
) {
    fun transform(): (Model) -> Boolean {
        return { model ->
            var result = true
            val statsValues = mutableListOf<StatValue>()
            model.info.stats.values.forEach {
                statsValues.addAll(it.values)
            }
            requiredStatsValuesIds.forEach { id ->
                result = result && statsValues.firstOrNull { it.id == id } != null
            }
            requiredFlagsIds.forEach {
                result = result && model.info.hiddenFlagsIds.contains(it)
            }
            unsuccessfulStatsValuesIds.forEach { id ->
                result = result && statsValues.firstOrNull { it.id == id } == null
            }
            unsuccessfulFlagsIds.forEach {
                result = result && !model.info.hiddenFlagsIds.contains(it)
            }
            result
        }
    }
}
