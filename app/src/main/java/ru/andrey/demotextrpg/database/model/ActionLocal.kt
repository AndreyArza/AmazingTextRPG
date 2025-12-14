package ru.andrey.demotextrpg.database.model

data class ActionLocal(
    val id: String,
    val parentStateId: String,
    val description: String,
    val sideEffect: SideEffectLocal,
    val failSideEffect: SideEffectLocal = sideEffect,

    // Перед отображением проверяется наличия статы в Info.statsValuesIds
    // пустой список - проверка не проводится, действие видно всегда
    // Если стата отсутствует, то считается как False, если есть и не типа BOOLEAN, то true
    // В иных случаях смотрится значение этой статы
    val visibilityCheckStatsWithValue: List<StatWithValueLocal> = listOf(),

    // При выполнении проверяется наличия необходимых флагов и статов, и отсутствие мешающих флагов и статов
    // null - проверка не проводится, действие видно всегда
    val successCheck: SuccessCheckLocal? = null,
)