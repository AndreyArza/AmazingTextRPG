package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Stat
import ru.andrey.demotextrpg.domain.model.StatValue
import ru.andrey.demotextrpg.network.model.data.StatWithValueData

interface StatsCheckMapper : Mapper<List<StatWithValueData>, Map<Stat, StatValue>, Boolean>
