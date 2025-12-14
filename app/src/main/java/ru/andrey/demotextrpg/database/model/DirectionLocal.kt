package ru.andrey.demotextrpg.database.model

data class DirectionLocal(
    val id: String,
    val name: String,
    val destinationId: String,
    val visibilityRequiredStats: List<StatWithValueLocal> = listOf(),
)