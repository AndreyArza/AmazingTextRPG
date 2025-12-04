package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.data.DeprecatedStatValue
import kotlinx.serialization.Serializable

@Serializable
data class SuccessCheck(
    //Сравнение идет по id и value
    val requiredStats: List<StatWithValueData> = listOf(),
    val unsuccessfulStats: List<StatWithValueData> = listOf(),
)
@Serializable
data class DeprecatedSuccessCheck(
    val requiredStatsValuesIds: List<String> = listOf(),
    val requiredFlagsIds: List<String> = listOf(),
    val unsuccessfulStatsValuesIds: List<String> = listOf(),
    val unsuccessfulFlagsIds: List<String> = listOf(),
) {
    fun transform(): (Model) -> Boolean {
        return { model ->
            var result = true
            val statsValues = mutableListOf<DeprecatedStatValue>()
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
