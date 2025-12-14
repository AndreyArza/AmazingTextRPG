package ru.andrey.demotextrpg.database.source.interfaces

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

class ActionLocalSourceImpl(
    val actionDao: ActionDao,
    val sideEffectDao: SideEffectDao,
    val statEventDao: StatEventDao,
    val relationActionToStatsDao: RelationActionToStatsDao

) : ActionLocalSource {
    override suspend fun getAllByGameId(gameId: String): List<ActionLocal> {
        return actionDao.getAllByGameId(gameId).map { entity ->
            val effects = sideEffectDao.loadAllByActionId(entity.id, gameId)
            val positiveEvents = statEventDao.loadAllBySideEffect(
                actionId = entity.id,
                sideEffectType = SideEffectType.POSITIVE,
                gameId = gameId
            )
            val positiveEffect = effects.first { it.type == SideEffectType.POSITIVE }
                .toLocal(positiveEvents.map { it.toLocal() })

            val negativeEvents = statEventDao.loadAllBySideEffect(
                actionId = entity.id,
                sideEffectType = SideEffectType.NEGATIVE,
                gameId = gameId
            )
            val negativeEffect = effects.firstOrNull { it.type == SideEffectType.NEGATIVE }
                ?.toLocal(negativeEvents.map { it.toLocal() })
            val stats = relationActionToStatsDao.loadAllByActionIds(entity.id, gameId)
            val visibilityStats =
                stats.filter { it.type == RelationActionToStatsType.VISIBILITY_CHECK }
            val requiredStats =
                stats.filter { it.type == RelationActionToStatsType.SUCCESS_CHECK_POSITIVE }
            val negativeStats =
                stats.filter { it.type == RelationActionToStatsType.SUCCESS_CHECK_NEGATIVE }
            entity.toLocal(
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
        sideEffectDao.insertAll(actions.map {
            it.failSideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.NEGATIVE
            )
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
        sideEffectDao.delete(actions.map {
            it.failSideEffect.toEntity(
                gameId = gameId,
                actionId = it.id,
                type = SideEffectType.NEGATIVE
            )
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

    private fun ActionEntity.toLocal(
        sideEffect: SideEffectLocal,
        failSideEffect: SideEffectLocal = sideEffect,
        visibilityCheckStatsWithValue: List<StatWithValueLocal>,
        successCheck: SuccessCheckLocal
    ): ActionLocal {
        return ActionLocal(
            id = id,
            parentStateId = stateId,
            description = description,
            sideEffect = sideEffect,
            failSideEffect = failSideEffect,
            visibilityCheckStatsWithValue = visibilityCheckStatsWithValue,
            successCheck = successCheck
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