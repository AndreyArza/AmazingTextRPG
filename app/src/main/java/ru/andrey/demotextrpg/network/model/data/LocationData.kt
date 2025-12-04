package ru.andrey.demotextrpg.network.model.data

import ru.andrey.demotextrpg.logic.data.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    val id: String,
    val defaultStateId: String,
    val description: String,
    val directionsIds: List<String>,
) {
    fun deprecatedTransform(): Location {
        return Location(
            id = id,
            defaultStateId = defaultStateId,
            description = description,
            directionsIds = directionsIds
        )
    }
}


