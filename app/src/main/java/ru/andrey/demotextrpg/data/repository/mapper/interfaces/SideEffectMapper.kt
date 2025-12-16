package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Model
import ru.andrey.demotextrpg.domain.model.Stat
import ru.andrey.demotextrpg.domain.model.StatValue
import ru.andrey.demotextrpg.network.model.data.SideEffectData

interface SideEffectMapper :
    Mapper<SideEffectData, Unit, (Pair<List<Stat>, List<StatValue>>, Model) -> Model>