package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.DirectionMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatsCheckMapper
import ru.andrey.demotextrpg.data.repository.model.Direction

class DirectionMapperImpl(
    val statsCheckMapper: StatsCheckMapper = StatsCheckMapperImpl()
) : DirectionMapper {
    override fun map(
        data: DirectionData,
        additionalInfo: Unit?
    ): Direction {
        return Direction(
            id = data.id,
            name = data.name,
            destinationId = data.destinationId,
            isVisible = { model ->
                statsCheckMapper.map(data.visibilityRequiredStats, model.stats)
            }
        )
    }
}