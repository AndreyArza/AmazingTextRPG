package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.custom_types.TabData
import ru.andrey.demotextrpg.database.dao.GameDao
import ru.andrey.demotextrpg.database.entities.GameEntity
import ru.andrey.demotextrpg.database.model.GameLocal
import ru.andrey.demotextrpg.database.model.TabLocal
import ru.andrey.demotextrpg.database.source.interfaces.GameLocalSource
import javax.inject.Inject

class GameLocalSourceImpl @Inject constructor(
    private val gameDao: GameDao
) : GameLocalSource {
    override suspend fun getAll(): List<GameLocal> {
        return gameDao.getAll().map { it.toLocal() }
    }

    override suspend fun loadAllByIds(ids: List<String>): List<GameLocal> {
        return gameDao.loadAllByIds(ids).map { it.toLocal() }
    }

    override suspend fun insertAll(games: List<GameLocal>) {
        gameDao.insertAll(games.map { it.toEntity() })
    }

    override suspend fun delete(games: List<GameLocal>) {
        gameDao.delete(games.map { it.toEntity() })
    }

    private fun GameEntity.toLocal(): GameLocal {
        return GameLocal(
            id = id,
            version = version,
            name = name,
            locationTabInfo = TabLocal(locationTabInfo.tabName, locationTabInfo.isVisible),
            stateTabInfo = TabLocal(stateTabInfo.tabName, stateTabInfo.isVisible),
            statsTabInfo = TabLocal(statsTabInfo.tabName, statsTabInfo.isVisible)
        )
    }

    private fun GameLocal.toEntity(): GameEntity {
        return GameEntity(
            id = id,
            version = version,
            name = name,
            locationTabInfo = TabData(locationTabInfo.tabName, locationTabInfo.isVisible),
            stateTabInfo = TabData(stateTabInfo.tabName, stateTabInfo.isVisible),
            statsTabInfo = TabData(statsTabInfo.tabName, statsTabInfo.isVisible)
        )
    }
}