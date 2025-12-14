package ru.andrey.demotextrpg.database.model

data class StatEventLocal(
    val statId: String,
    val statValueId: String,
    val type: StatEventTypeLocal,
)