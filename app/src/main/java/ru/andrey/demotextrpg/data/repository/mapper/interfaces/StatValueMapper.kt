package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.data.repository.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatValueData

interface StatValueMapper : Mapper<StatValueData, Unit, StatValue>