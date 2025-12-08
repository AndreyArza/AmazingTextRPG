package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatsCheckMapper
import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.data.repository.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatWithValueData

class StatsCheckMapperImpl : StatsCheckMapper {
    override fun map(
        data: List<StatWithValueData>,
        additionalInfo: Map<Stat, StatValue>?
    ): Boolean {
        return data.all { statWithValue ->
            val map = additionalInfo ?: mapOf()
            map[map.keys.first { it.id == statWithValue.statId }]?.id == statWithValue.valueId
        }
    }
}

