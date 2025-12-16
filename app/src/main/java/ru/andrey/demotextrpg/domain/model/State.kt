package ru.andrey.demotextrpg.domain.model

data class State(
    val id: String,
    val description: String,
    val actions: List<Action> = listOf(),
)