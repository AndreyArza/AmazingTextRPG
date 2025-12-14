package ru.andrey.demotextrpg.database.model

data class StatValueLocal(
    val id: String,
    val statId: String,
    val value: String = "",
    val type: StatTypeLocal = StatTypeLocal.STRING,
)