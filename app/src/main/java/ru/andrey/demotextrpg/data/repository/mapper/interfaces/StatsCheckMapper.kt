package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.data.repository.model.Stat
import ru.andrey.demotextrpg.data.repository.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatWithValueData

interface StatsCheckMapper : Mapper<List<StatWithValueData>, Map<Stat, StatValue>, Boolean>
