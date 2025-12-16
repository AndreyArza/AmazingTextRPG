package ru.andrey.demotextrpg.database.source.impementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.andrey.demotextrpg.database.dao.ModelDao
import ru.andrey.demotextrpg.database.dao.RelationModelToStatsDao
import ru.andrey.demotextrpg.database.entities.ModelEntity
import ru.andrey.demotextrpg.database.entities.RelationModelToStatsEntity
import ru.andrey.demotextrpg.database.model.ModelLocal
import ru.andrey.demotextrpg.database.model.StatWithValueLocal
import ru.andrey.demotextrpg.database.source.interfaces.ModelLocalSource
import javax.inject.Inject

class ModelLocalSourceImpl @Inject constructor(
    private val modelDao: ModelDao,
    private val relationModelToStatsDao: RelationModelToStatsDao
) : ModelLocalSource {
    override suspend fun loadByGameId(gameId: String): Flow<ModelLocal> {
        return modelDao.loadByGameId(gameId).map { entity ->
            entity.toLocal(gameId)
        }
    }

    override suspend fun insert(model: ModelLocal, gameId: String) {
        modelDao.insertAll(listOf(model.toEntity(gameId)))
        relationModelToStatsDao.insertAll(model.statsWithValuesIds.map {
            RelationModelToStatsEntity(
                gameId = gameId,
                statId = it.statId,
                valueId = it.valueId
            )
        })
    }

    override suspend fun delete(model: ModelLocal, gameId: String) {
        modelDao.delete(listOf(model.toEntity(gameId)))
        relationModelToStatsDao.delete(model.statsWithValuesIds.map {
            RelationModelToStatsEntity(
                gameId = gameId,
                statId = it.statId,
                valueId = it.valueId
            )
        })
    }

    private suspend fun ModelEntity.toLocal(gameId: String): ModelLocal {
        val stats = relationModelToStatsDao.loadAllByGameId(gameId)
        return ModelLocal(
            locationId = locationId,
            stateId = stateId,
            statsWithValuesIds = stats.map {
                StatWithValueLocal(
                    statId = it.statId,
                    valueId = it.valueId
                )
            }
        )
    }

    private fun ModelLocal.toEntity(gameId: String): ModelEntity {
        return ModelEntity(
            gameId = gameId,
            locationId = locationId,
            stateId = stateId
        )
    }
}