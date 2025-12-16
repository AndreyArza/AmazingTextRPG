package ru.andrey.demotextrpg.domain.model

data class StatValue(
    val id: String,
    val statId: String,
    val value: String = "",
    val type: StatType = StatType.STRING,
)