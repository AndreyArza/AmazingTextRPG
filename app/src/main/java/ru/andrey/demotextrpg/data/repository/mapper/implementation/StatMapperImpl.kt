package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatMapper
import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.network.model.data.StatData

class StatMapperImpl : StatMapper {
    override fun map(
        data: StatData,
        additionalInfo: Unit?
    ): Stat {
        return Stat(
            id = data.id,
            name = data.name,
            sortField = data.sortField,
            isVisible = data.isVisible
        )
    }
}