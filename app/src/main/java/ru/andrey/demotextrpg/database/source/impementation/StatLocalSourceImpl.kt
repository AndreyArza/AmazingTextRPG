package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.custom_types.StatType
import ru.andrey.demotextrpg.database.dao.StatDao
import ru.andrey.demotextrpg.database.dao.StatValueDao
import ru.andrey.demotextrpg.database.entities.StatEntity
import ru.andrey.demotextrpg.database.entities.StatValueEntity
import ru.andrey.demotextrpg.database.model.StatLocal
import ru.andrey.demotextrpg.database.model.StatTypeLocal
import ru.andrey.demotextrpg.database.model.StatValueLocal
import ru.andrey.demotextrpg.database.source.interfaces.StatLocalSource
import javax.inject.Inject

class StatLocalSourceImpl @Inject constructor(
    private val statDao: StatDao,
    private val statValueDao: StatValueDao,
) : StatLocalSource {
    override suspend fun getAllByGameId(gameId: String): List<StatLocal> {
        return statDao.getAllByGameId(gameId).map { it.toLocal() }
    }

    override suspend fun loadAllByIds(ids: List<String>): List<StatLocal> {
        return statDao.loadAllByIds(ids).map { it.toLocal() }
    }

    override suspend fun insertAllStats(gameId: String, stats: List<StatLocal>) {
        statDao.insertAll(stats.map { it.toEntity(gameId) })
    }

    override suspend fun deleteStats(stats: List<StatLocal>, gameId: String) {
        statDao.delete(stats.map { it.toEntity(gameId) })
    }

    override suspend fun getAllValuesByGameId(gameId: String): List<StatValueLocal> {
        return statValueDao.getAllByGameId(gameId).map { it.toLocal() }
    }

    override suspend fun loadAllValuesByIds(ids: List<String>): List<StatValueLocal> {
        return statValueDao.loadAllByIds(ids).map { it.toLocal() }
    }

    override suspend fun insertAllValues(gameId: String, stats: List<StatValueLocal>) {
        statValueDao.insertAll(stats.map { it.toEntity(gameId) })
    }

    override suspend fun deleteValues(stats: List<StatValueLocal>, gameId: String) {
        statValueDao.delete(stats.map { it.toEntity(gameId) })
    }

    private fun StatValueEntity.toLocal(): StatValueLocal {
        return StatValueLocal(
            id = id,
            statId = statId,
            value = value,
            type = StatTypeLocal.valueOf(type.name)
        )
    }

    private fun StatValueLocal.toEntity(gameId: String): StatValueEntity {
        return StatValueEntity(
            id = id,
            gameId = gameId,
            statId = statId,
            value = value,
            type = StatType.valueOf(type.name),
        )
    }

    private fun StatEntity.toLocal(): StatLocal {
        return StatLocal(
            id = id,
            name = name,
            sortField = sortField,
            isVisible = isVisible
        )
    }

    private fun StatLocal.toEntity(gameId: String): StatEntity {
        return StatEntity(
            id = id,
            gameId = gameId,
            name = name,
            sortField = sortField,
            isVisible = isVisible
        )
    }
}