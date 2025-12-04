package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.data.repository.model.Direction

interface DirectionMapper: Mapper<DirectionData, Unit, Direction>