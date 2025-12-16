package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.SideEffectMapper
import ru.andrey.demotextrpg.domain.model.Model
import ru.andrey.demotextrpg.domain.model.Stat
import ru.andrey.demotextrpg.domain.model.StatValue
import ru.andrey.demotextrpg.network.model.data.SideEffectData
import ru.andrey.demotextrpg.network.model.data.StatEventTypeData

class SideEffectMapperImpl : SideEffectMapper {
    override fun map(
        data: SideEffectData,
        additionalInfo: Unit?
    ): (Pair<List<Stat>, List<StatValue>>, Model) -> Model {
        return { pair, model ->
            val newStateId = data.newStateId
            val newLocationId = data.newLocationId
            val newStats = model.stats.toMutableMap()
            val allStats = pair.first
            val allStatsValues = pair.second

            data.statEvents.forEach { event ->
                when (event.type) {
                    StatEventTypeData.ADD, StatEventTypeData.UPDATE -> {
                        val stat = allStats.firstOrNull { it.id == event.statId }
                        val statValue = allStatsValues.firstOrNull { it.id == event.statValueId }
                        if (stat != null && statValue != null) {
                            newStats[stat] = statValue
                        }
                    }

                    StatEventTypeData.REMOVE -> {
                        newStats.remove(allStats.firstOrNull { it.id == event.statId })
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