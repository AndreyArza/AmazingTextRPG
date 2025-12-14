package ru.andrey.demotextrpg.database.model

data class LocationLocal(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directionsIds: List<String>,
)


