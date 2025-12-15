package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.dao.LocationDao
import ru.andrey.demotextrpg.database.entities.LocationEntity
import ru.andrey.demotextrpg.database.model.LocationLocal
import ru.andrey.demotextrpg.database.source.interfaces.DirectionLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.LocationLocalSource
import javax.inject.Inject

class LocationLocalSourceImpl @Inject constructor(
    private val locationDao: LocationDao,
    private val directionLocalSource: DirectionLocalSource
) : LocationLocalSource {
    override suspend fun getAllByGameId(gameId: String): List<LocationLocal> {
        return locationDao.loadAllByGameId(gameId).map { it.toLocal(gameId) }
    }

    override suspend fun loadAllByIds(gameId: String, ids: List<String>): List<LocationLocal> {
        return locationDao.loadAllByIds(gameId, ids).map { it.toLocal(gameId) }
    }

    override suspend fun insertAllLocation(
        gameId: String,
        locations: List<LocationLocal>
    ) {
        locationDao.insertAll(locations.map { it.toEntity(gameId) })
    }

    override suspend fun deleteLocations(
        gameId: String,
        locations: List<LocationLocal>
    ) {
        locationDao.delete(locations.map { it.toEntity(gameId) })
    }

    private suspend fun LocationEntity.toLocal(gameId: String): LocationLocal {
        val directions = directionLocalSource.getAllByLocationId(
            locationId = id,
            gameId = gameId
        ).map { it.id }
        return LocationLocal(
            id = id,
            defaultStateId = defaultStateId,
            description = description,
            directionsIds = directions
        )
    }
    private fun LocationLocal.toEntity(gameId: String): LocationEntity {
        return LocationEntity(
            id = id,
            gameId = gameId,
            defaultStateId = defaultStateId,
            description = description
        )
    }
}