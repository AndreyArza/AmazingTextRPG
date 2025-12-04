package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.StatValueData
import ru.andrey.demotextrpg.data.repository.model.StatValue

interface StatValueMapper: Mapper<StatValueData, Unit, StatValue>