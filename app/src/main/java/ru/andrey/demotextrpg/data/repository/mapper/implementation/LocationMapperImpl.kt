package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.LocationMapper
import ru.andrey.demotextrpg.data.repository.model.Direction
import ru.andrey.demotextrpg.data.repository.model.Location
import ru.andrey.demotextrpg.network.model.data.LocationData

class LocationMapperImpl : LocationMapper {
    override fun map(
        data: LocationData,
        additionalInfo: List<Direction>?
    ): Location {
        val allDirections = additionalInfo ?: listOf()

        return Location(
            id = data.id,
            defaultStateId = data.defaultStateId,
            description = data.description,
            directions = data.directionsIds.mapNotNull { directionId ->
                allDirections.firstOrNull { it.id == directionId }
            }
        )
    }
}