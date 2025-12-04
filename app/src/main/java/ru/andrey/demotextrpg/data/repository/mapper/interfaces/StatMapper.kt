package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.data.repository.model.Stat

interface StatMapper: Mapper<StatData, Unit, Stat>