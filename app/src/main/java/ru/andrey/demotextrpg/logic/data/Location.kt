package ru.andrey.demotextrpg.logic.data

data class Location(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directionsIds: List<String>,
)