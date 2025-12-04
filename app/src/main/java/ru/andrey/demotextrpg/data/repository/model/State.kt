package ru.andrey.demotextrpg.data.repository.model

data class State(
    val id: String,
    val description: String,
    val actions: List<Action> = listOf(),
)