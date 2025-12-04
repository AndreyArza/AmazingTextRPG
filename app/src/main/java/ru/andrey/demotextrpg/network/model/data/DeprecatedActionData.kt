package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Action
import kotlinx.serialization.Serializable

@Serializable
data class ActionData(
    val id: String,
    val parentStateId: String,
    val description: String,
    val sideEffect: SideEffectData,
    val failSideEffect: SideEffectData = sideEffect,

    // Перед отображением проверяется наличия статы в Info.statsValuesIds
    // пустой список - проверка не проводится, действие видно всегда
    // Если стата отсутствует, то считается как False, если есть и не типа BOOLEAN, то true
    // В иных случаях смотрится значение этой статы
    val visibilityCheckStatsWithValue: List<StatWithValueData> = listOf(),

    // При выполнении проверяется наличия необходимых флагов и статов, и отсутствие мешающих флагов и статов
    // null - проверка не проводится, действие видно всегда
    val successCheck: SuccessCheck? = null,
)


@Serializable
data class DeprecatedActionData(
    val id: String,
    val description: String,
    val sideEffect: DeprecatedSideEffectData,
    val failSideEffect: DeprecatedSideEffectData = sideEffect,

    // Перед отображением проверяется наличия статы в Info.statsValuesIds
    // пустой список - проверка не проводится, действие видно всегда
    // Если стата отсутствует, то считается как False, если есть и не типа BOOLEAN, то true
    // В иных случаях смотрится значение этой статы
    val visibilityFlagsIds: List<String> = listOf(),

    // При выполнении проверяется наличия необходимых флагов и статов, и отсутствие мешающих флагов и статов
    // null - проверка не проводится, действие видно всегда
    val successCheck: DeprecatedSuccessCheck? = null,
) {
    fun transform(): Action {
        return Action(
            id = id,
            description = description,
            sideEffect = sideEffect.transform(),
            failSideEffect = failSideEffect.transform(),
            isVisible = { model ->
                visibilityFlagsIds.all { model.info.hiddenFlagsIds.contains(it) }
            },
            successCheck = successCheck?.transform() ?: { true }
        )
    }
}

