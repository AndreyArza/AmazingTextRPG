package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Direction
import ru.andrey.demotextrpg.network.model.data.DirectionData

interface DirectionMapper : Mapper<DirectionData, Unit, Direction>