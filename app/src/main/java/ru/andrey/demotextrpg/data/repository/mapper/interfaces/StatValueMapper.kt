package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatValueData

interface StatValueMapper : Mapper<StatValueData, Unit, StatValue>