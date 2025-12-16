package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.domain.model.Action
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.ModelData

interface ActionMapper : Mapper<ActionData, ModelData, Action>