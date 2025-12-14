package ru.andrey.demotextrpg.database.model

data class SuccessCheckLocal(
    val requiredStats: List<StatWithValueLocal> = listOf(),
    val unsuccessfulStats: List<StatWithValueLocal> = listOf(),
)