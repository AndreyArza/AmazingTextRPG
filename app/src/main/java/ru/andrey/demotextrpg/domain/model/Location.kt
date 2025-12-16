package ru.andrey.demotextrpg.domain.model

data class Location(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directions: List<Direction>,
)