package ru.andrey.demotextrpg.logic.data

data class Info(
    val stats: Map<String, Stat>,
    val hiddenFlagsIds: MutableSet<String>
)