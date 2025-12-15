package ru.andrey.demotextrpg.database.source.impementation

import ru.andrey.demotextrpg.database.custom_types.RelationActionToStatsType
import ru.andrey.demotextrpg.database.custom_types.SideEffectType
import ru.andrey.demotextrpg.database.custom_types.StatEventType
import ru.andrey.demotextrpg.database.dao.ActionDao
import ru.andrey.demotextrpg.database.dao.RelationActionToStatsDao
import ru.andrey.demotextrpg.database.dao.SideEffectDao
import ru.andrey.demotextrpg.database.dao.StatEventDao
import ru.andrey.demotextrpg.database.entities.ActionEntity
import ru.andrey.demotextrpg.database.entities.RelationActionToStatsEntity
import ru.andrey.demotextrpg.database.entities.SideEffectEntity
import ru.andrey.demotextrpg.database.entities.StatEventEntity
import ru.andrey.demotextrpg.database.model.ActionLocal
import ru.andrey.demotextrpg.database.model.SideEffectLocal
import ru.andrey.demotextrpg.database.model.StatEventLocal
import ru.andrey.demotextrpg.database.model.StatEventTypeLocal
import ru.andrey.demotextrpg.database.model.StatWithValueLocal
import ru.andrey.demotextrpg.database.model.SuccessCheckLocal
import ru.andrey.demotextrpg.database.source.interfaces.ActionLocalSource
import javax.inject.Inject

class ActionLocalSourceImpl @Inject constructor(
    val actionDao: ActionDao,
    val sideEffectDao: SideEffectDao,
    val statEventDao: StatEventDao,
    val relationActionToStatsDao: RelationActionToStatsDao

) : ActionLocalSource {
    override suspend fun getAllByGameId(gameId: String): List<ActionLocal> {
        return actionDao.getAllByGameId(gameId).map { it.toLocal() }
    }

    override suspend fun getAllByStateId(
        stateId: String,
        gameId: String
    ): List<ActionLocal> {
        return actionDao.loadAllByStateId(stateId, gameId).map { it.toLocal() }
    }

    override suspend fun getById(
        id: String,
        gameId: String
    ): ActionLocal {
        return actionDao.loadAllByIds(listOf(id), gameId).map { it.toLocal() }.first()
    }

    override suspend fun insertAllActions(
        gameId: String,
        actions: List<ActionLocal>
    ) {
        actionDao.insertAll(actions.map { it.toEntity(gameId) })
        sideEffectDao.insertAll(actions.map {
            it.sideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.POSITIVE
            )
        })
        statEventDao.insertAll(actions.flatMap { action ->
            action.sideEffect.statEvents.map {
                it.toEntity(
                    gameId = gameId,
                    actionId = action.id,
                    effectType = SideEffectType.POSITIVE
                )
            }
        })
        sideEffectDao.insertAll(actions.map {
            it.failSideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.NEGATIVE
            )
        })
        statEventDao.insertAll(actions.flatMap { action ->
            action.failSideEffect.statEvents.map {
                it.toEntity(
                    gameId = gameId,
                    actionId = action.id,
                    effectType = SideEffectType.NEGATIVE
                )
            }
        })
        actions.forEach { action ->
            relationActionToStatsDao.insertAll(
                action.visibilityCheckStatsWithValue.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.VISIBILITY_CHECK
                    )
                }
            )
            relationActionToStatsDao.insertAll(
                action.successCheck?.requiredStats?.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.SUCCESS_CHECK_POSITIVE
                    )
                } ?: listOf()
            )
            relationActionToStatsDao.insertAll(
                action.successCheck?.requiredStats?.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.SUCCESS_CHECK_NEGATIVE
                    )
                } ?: listOf()
            )
        }
    }

    override suspend fun deleteActions(
        gameId: String,
        actions: List<ActionLocal>
    ) {
        actionDao.delete(actions.map { it.toEntity(gameId) })
        sideEffectDao.delete(actions.map {
            it.sideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.POSITIVE
            )
        })
        statEventDao.delete(actions.flatMap { action ->
            action.sideEffect.statEvents.map {
                it.toEntity(
                    gameId = gameId,
                    actionId = action.id,
                    effectType = SideEffectType.POSITIVE
                )
            }
        })
        sideEffectDao.delete(actions.map {
            it.failSideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.NEGATIVE
            )
        })
        statEventDao.delete(actions.flatMap { action ->
            action.failSideEffect.statEvents.map {
                it.toEntity(
                    gameId = gameId,
                    actionId = action.id,
                    effectType = SideEffectType.NEGATIVE
                )
            }
        })
        actions.forEach { action ->
            relationActionToStatsDao.delete(
                action.visibilityCheckStatsWithValue.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.VISIBILITY_CHECK
                    )
                }
            )
            relationActionToStatsDao.delete(
                action.successCheck?.requiredStats?.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.SUCCESS_CHECK_POSITIVE
                    )
                } ?: listOf()
            )
            relationActionToStatsDao.delete(
                action.successCheck?.requiredStats?.map { statWithValueLocal ->
                    RelationActionToStatsEntity(
                        gameId = gameId,
                        actionId = action.id,
                        statId = statWithValueLocal.statId,
                        valueId = statWithValueLocal.valueId,
                        type = RelationActionToStatsType.SUCCESS_CHECK_NEGATIVE
                    )
                } ?: listOf()
            )
        }
    }

    private fun ActionLocal.toEntity(gameId: String): ActionEntity {
        return ActionEntity(
            id = id,
            gameId = gameId,
            stateId = parentStateId,
            description = description
        )
    }

    private suspend fun ActionEntity.toLocal(
    ): ActionLocal {
        val effects = sideEffectDao.loadAllByActionId(id, gameId)
        val positiveEvents = statEventDao.loadAllBySideEffect(
            actionId = id,
            sideEffectType = SideEffectType.POSITIVE,
            gameId = gameId
        )
        val positiveEffect = effects.first { it.type == SideEffectType.POSITIVE }
            .toLocal(positiveEvents.map { it.toLocal() })

        val negativeEvents = statEventDao.loadAllBySideEffect(
            actionId = id,
            sideEffectType = SideEffectType.NEGATIVE,
            gameId = gameId
        )
        val negativeEffect = effects.firstOrNull { it.type == SideEffectType.NEGATIVE }
            ?.toLocal(negativeEvents.map { it.toLocal() })
        val stats = relationActionToStatsDao.loadAllByActionIds(id, gameId)
        val visibilityStats =
            stats.filter { it.type == RelationActionToStatsType.VISIBILITY_CHECK }
        val requiredStats =
            stats.filter { it.type == RelationActionToStatsType.SUCCESS_CHECK_POSITIVE }
        val negativeStats =
            stats.filter { it.type == RelationActionToStatsType.SUCCESS_CHECK_NEGATIVE }

        return ActionLocal(
            id = id,
            parentStateId = stateId,
            description = description,
            sideEffect = positiveEffect,
            failSideEffect = negativeEffect ?: positiveEffect,
            visibilityCheckStatsWithValue = visibilityStats.map {
                StatWithValueLocal(
                    it.statId,
                    it.valueId
                )
            },
            successCheck = SuccessCheckLocal(
                requiredStats = requiredStats.map { StatWithValueLocal(it.statId, it.valueId) },
                unsuccessfulStats = negativeStats.map {
                    StatWithValueLocal(
                        it.statId,
                        it.valueId
                    )
                }
            )
        )
    }

    private fun SideEffectEntity.toLocal(statEvents: List<StatEventLocal>): SideEffectLocal {
        return SideEffectLocal(
            newStateId = newStateId,
            newLocationId = newLocationId,
            statEvents = statEvents
        )
    }

    private fun SideEffectLocal.toEntity(
        gameId: String,
        actionId: String,
        type: SideEffectType
    ): SideEffectEntity {
        return SideEffectEntity(
            gameId = gameId,
            actionId = actionId,
            type = type,
            newStateId = newStateId,
            newLocationId = newLocationId
        )
    }

    private fun StatEventEntity.toLocal(): StatEventLocal {
        return StatEventLocal(
            statId = statId,
            statValueId = statValueId,
            type = StatEventTypeLocal.valueOf(type.name)
        )
    }

    private fun StatEventLocal.toEntity(
        gameId: String,
        actionId: String,
        effectType: SideEffectType
    ): StatEventEntity {
        return StatEventEntity(
            statId = statId,
            statValueId = statValueId,
            type = StatEventType.valueOf(type.name),
            gameId = gameId,
            actionId = actionId,
            effectType = effectType
        )
    }
}