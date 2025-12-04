package ru.andrey.demotextrpg.logic.data

data class Stat(
    val id: String,
    val order: Int,
    val name: String,
    val values: MutableSet<DeprecatedStatValue>
)