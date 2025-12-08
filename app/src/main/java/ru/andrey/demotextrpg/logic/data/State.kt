package ru.andrey.demotextrpg.logic.data

data class State(
    val id: String,
    val description: String,
    val actions: List<Action> = listOf(),
)