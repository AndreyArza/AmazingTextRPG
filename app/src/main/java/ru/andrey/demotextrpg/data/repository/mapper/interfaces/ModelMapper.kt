package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Model
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData

interface ModelMapper : Mapper<ModelData, Pair<List<StatData>, List<StatValueData>>, Model>