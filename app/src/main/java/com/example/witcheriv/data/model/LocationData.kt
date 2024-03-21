package com.example.witcheriv.data.model

import com.example.witcheriv.logic.data.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directionsIds: List<String>,
) {
    fun transform(): Location {
        return Location(
            id = id,
            defaultStateId = defaultStateId,
            description = description,
            directionsIds = directionsIds
        )
    }
}


