package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.network.model.data.SideEffectData
import ru.andrey.demotextrpg.network.model.data.StatEventTypeData
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.SideEffectMapper
import ru.andrey.demotextrpg.data.repository.model.Game
import ru.andrey.demotextrpg.data.repository.model.Model

class SideEffectMapperImpl : SideEffectMapper {
    override fun map(
        data: SideEffectData,
        additionalInfo: Unit?
    ): (Game, Model) -> Model {
        return { game, model ->
            val newStateId = data.newStateId
            val newLocationId = data.newLocationId
            val newStats = model.stats.toMutableMap()

            data.statEvents.forEach { event ->
                when (event.type) {
                    StatEventTypeData.ADD, StatEventTypeData.UPDATE -> {
                        val stat = game.allStats[event.statId]
                        val statValue = game.allStatsValues[event.statValueId]
                        if (stat != null && statValue != null) {
                            newStats[stat] = statValue
                        }
                    }

                    StatEventTypeData.REMOVE -> {
                        newStats.remove(game.allStats[event.statId])
                    }
                }
            }
            model.copy(
                locationId = newLocationId ?: model.locationId,
                stateId = newStateId ?: model.stateId,
                stats = newStats.toSortedMap { o1, o2 -> o1.sortField.compareTo(o2.sortField) }
            )
        }
    }

}