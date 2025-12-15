package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.ActionLocal

interface ActionLocalSource {
    suspend fun getAllByGameId(gameId: String): List<ActionLocal>
    suspend fun getAllByStateId(stateId:String, gameId: String): List<ActionLocal>
    suspend fun getById(id:String, gameId: String): ActionLocal

    suspend fun insertAllActions(gameId: String, actions: List<ActionLocal>)

    suspend fun deleteActions(gameId: String, actions: List<ActionLocal>)
}