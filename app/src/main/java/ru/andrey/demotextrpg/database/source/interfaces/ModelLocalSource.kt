package ru.andrey.demotextrpg.database.source.interfaces

import kotlinx.coroutines.flow.Flow
import ru.andrey.demotextrpg.database.model.ModelLocal

interface ModelLocalSource {
    suspend fun loadByGameId(gameId: String): Flow<ModelLocal>

    suspend fun insert(model: ModelLocal, gameId: String)

    suspend fun delete(model: ModelLocal, gameId: String)
}