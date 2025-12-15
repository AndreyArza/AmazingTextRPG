package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.DirectionLocal

interface DirectionLocalSource {
    suspend fun getAllByGameId(gameId: String): List<DirectionLocal>

    suspend fun getAllByLocationId(locationId:String, gameId: String): List<DirectionLocal>

    suspend fun getById(id:String, gameId: String): DirectionLocal

    suspend fun insertAllDirections(
        gameId: String,
        locationId: String,
        directions: List<DirectionLocal>
    )

    suspend fun deleteDirections(
        gameId: String,
        locationId: String,
        directions: List<DirectionLocal>
    )

}