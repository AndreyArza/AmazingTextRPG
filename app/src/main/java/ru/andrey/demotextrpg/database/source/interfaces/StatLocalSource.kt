package ru.andrey.demotextrpg.database.source.interfaces

import ru.andrey.demotextrpg.database.model.StatLocal
import ru.andrey.demotextrpg.database.model.StatValueLocal

interface StatLocalSource {
    suspend fun getAllByGameId(gameId: String): List<StatLocal>

    suspend fun loadAllByIds(ids: List<String>): List<StatLocal>

    suspend fun insertAllStats(gameId: String, stats: List<StatLocal>)

    suspend fun deleteStats(stats: List<StatLocal>, gameId: String)

    suspend fun getAllValuesByGameId(gameId: String): List<StatValueLocal>

    suspend fun loadAllValuesByIds(ids: List<String>): List<StatValueLocal>

    suspend fun insertAllValues(gameId: String, stats: List<StatValueLocal>)

    suspend fun deleteValues(stats: List<StatValueLocal>, gameId: String)
}