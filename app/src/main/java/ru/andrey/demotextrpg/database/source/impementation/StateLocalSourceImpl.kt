package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.dao.StateDao
import ru.andrey.demotextrpg.database.entities.StateEntity
import ru.andrey.demotextrpg.database.model.StateLocal
import ru.andrey.demotextrpg.database.source.interfaces.StateLocalSource
import javax.inject.Inject

class StateLocalSourceImpl @Inject constructor(
    private val stateDao: StateDao
) : StateLocalSource {

    override suspend fun getAllByGameId(gameId: String): List<StateLocal> {
        return stateDao.getAllByGameId(gameId).map { it.toLocal() }
    }

    override suspend fun loadAllByIds(gameId: String, ids: List<String>): List<StateLocal> {
        return stateDao.loadAllByIds(ids, gameId).map { it.toLocal() }
    }

    override suspend fun insertAllStates(gameId: String, states: List<StateLocal>) {
        stateDao.insertAll(states.map { it.toEntity(gameId) })
    }

    override suspend fun deleteStates(gameId: String, states: List<StateLocal>) {
        stateDao.delete(states.map { it.toEntity(gameId) })
    }

    private fun StateLocal.toEntity(gameId: String): StateEntity {
        return StateEntity(
            id = id,
            gameId = gameId,
            description = description
        )
    }

    private fun StateEntity.toLocal(): StateLocal {
        return StateLocal(
            id = id,
            description = description
        )
    }
}