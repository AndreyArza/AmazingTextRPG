package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Action
import kotlinx.serialization.Serializable


@Serializable
data class ActionData(
    val id: String,
    val description: String,
    val sideEffect: SideEffectData,
    val failSideEffect: SideEffectData = sideEffect,

    // Перед отображением проверяется наличия флага в Info.hiddenFlagsIds
    // пустой список - проверка не проводится, действие видно всегда
    val visibilityFlagsIds: List<String> = listOf(),

    // При выполнении проверяется наличия необходимых флагов и статов, и отсутствие мешающих флагов и статов
    // null - проверка не проводится, действие видно всегда
    val successCheck: SuccessCheck? = null,
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

