package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.StateLocal


interface StateLocalSource {
    suspend fun getAllByGameId(gameId: String): List<StateLocal>

    suspend fun loadAllByIds(gameId: String, ids: List<String>): List<StateLocal>

    suspend fun insertAllStates(gameId: String, states: List<StateLocal>)

    suspend fun deleteStates(gameId: String, states: List<StateLocal>)
}