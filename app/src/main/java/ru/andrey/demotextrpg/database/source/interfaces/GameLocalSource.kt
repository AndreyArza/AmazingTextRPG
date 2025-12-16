package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.GameLocal

interface GameLocalSource {
    suspend fun getAll(): List<GameLocal>

    suspend fun loadAllByIds(ids: List<String>): List<GameLocal>

    suspend fun insertAll(games: List<GameLocal>)

    suspend fun delete(games: List<GameLocal>)
}