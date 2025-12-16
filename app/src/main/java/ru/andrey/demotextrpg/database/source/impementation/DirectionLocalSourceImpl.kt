package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.dao.DirectionDao
import ru.andrey.demotextrpg.database.dao.RelationDirectionToStatsDao
import ru.andrey.demotextrpg.database.entities.DirectionEntity
import ru.andrey.demotextrpg.database.entities.RelationDirectionToStatsEntity
import ru.andrey.demotextrpg.database.model.DirectionLocal
import ru.andrey.demotextrpg.database.model.StatWithValueLocal
import ru.andrey.demotextrpg.database.source.interfaces.DirectionLocalSource
import javax.inject.Inject

class DirectionLocalSourceImpl @Inject constructor(
    private val directionDao: DirectionDao,
    private val relationDirectionToStatsDao: RelationDirectionToStatsDao
) : DirectionLocalSource {
    override suspend fun getAllByGameId(gameId: String): List<DirectionLocal> {
        return directionDao.getAllByGameId(gameId).map { it.toLocal() }
    }

    override suspend fun getAllByLocationId(
        locationId: String,
        gameId: String
    ): List<DirectionLocal> {
        return directionDao.loadByLocationId(listOf(locationId), gameId).map { it.toLocal() }
    }

    override suspend fun getById(
        id: String,
        gameId: String
    ): DirectionLocal {
        return directionDao.loadAllByIds(listOf(id), gameId).map { it.toLocal() }.first()
    }

    override suspend fun insertAllDirections(
        gameId: String,
        locationId: String,
        directions: List<DirectionLocal>
    ) {
        directionDao.insertAll(directions.map {
            it.toEntity(
                gameId = gameId,
                locationId = locationId
            )
        })
        directions.forEach { direction ->
            relationDirectionToStatsDao.insertAll(
                direction.visibilityRequiredStats.map { statWithValueLocal ->
                    RelationDirectionToStatsEntity(
                        gameId = gameId,
                        directionId = direction.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                    )
                }
            )
        }
    }

    override suspend fun deleteDirections(
        gameId: String,
        locationId: String,
        directions: List<DirectionLocal>
    ) {
        directionDao.delete(directions.map {
            it.toEntity(
                gameId = gameId,
                locationId = locationId
            )
        })
        directions.forEach { direction ->
            relationDirectionToStatsDao.delete(
                direction.visibilityRequiredStats.map { statWithValueLocal ->
                    RelationDirectionToStatsEntity(
                        gameId = gameId,
                        directionId = direction.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                    )
                }
            )
        }
    }

    private suspend fun DirectionEntity.toLocal(): DirectionLocal {
        val stats = relationDirectionToStatsDao.loadAllByDirectionId(id, gameId)
        return DirectionLocal(
            id = id,
            name = name,
            destinationId = destinationId,
            visibilityRequiredStats = stats.map {
                StatWithValueLocal(
                    it.statId,
                    it.valueId
                )
            },
        )
    }

    private fun DirectionLocal.toEntity(gameId: String, locationId: String): DirectionEntity {
        return DirectionEntity(
            id = id,
            gameId = gameId,
            locationId = locationId,
            name = name,
            destinationId = destinationId
        )
    }
}