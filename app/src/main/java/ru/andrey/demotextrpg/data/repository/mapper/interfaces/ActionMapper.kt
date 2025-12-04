package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.data.repository.model.Action

interface ActionMapper : Mapper<ActionData, ModelData, Action>