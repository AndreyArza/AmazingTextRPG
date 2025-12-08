package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.network.model.data.StatData

interface StatMapper : Mapper<StatData, Unit, Stat>