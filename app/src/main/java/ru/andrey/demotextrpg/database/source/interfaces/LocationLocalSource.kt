package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.LocationLocal


interface LocationLocalSource {
    suspend fun getAllByGameId(gameId: String): List<LocationLocal>

    suspend fun loadAllByIds(gameId: String, ids: List<String>): List<LocationLocal>

    suspend fun insertAllLocation(gameId: String, locations: List<LocationLocal>)

    suspend fun deleteLocations(gameId: String, locations: List<LocationLocal>)
}