package ru.andrey.demotextrpg.logic.data

import ru.andrey.demotextrpg.logic.data.Action

data class State(
    val id: String,
    val description: String,
    val actions: List<Action> = listOf(),
)