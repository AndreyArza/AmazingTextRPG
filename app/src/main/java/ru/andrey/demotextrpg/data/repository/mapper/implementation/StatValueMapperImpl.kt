package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatValueMapper
import ru.andrey.demotextrpg.data.repository.model.StatType
import ru.andrey.demotextrpg.data.repository.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatValueData

class StatValueMapperImpl : StatValueMapper {
    override fun map(
        data: StatValueData,
        additionalInfo: Unit?
    ): StatValue {
        return StatValue(
            id = data.id,
            statId = data.statId,
            value = data.value,
            type = StatType.valueOf(data.type.name)
        )
    }
}