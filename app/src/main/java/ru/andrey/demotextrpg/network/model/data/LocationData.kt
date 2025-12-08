package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directionsIds: List<String>,
)


