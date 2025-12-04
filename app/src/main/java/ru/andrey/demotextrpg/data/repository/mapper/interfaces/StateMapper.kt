package ru.andrey.demotextrpg.data.repository.mapper.interfaces

import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.StateData
import ru.andrey.demotextrpg.data.repository.model.State

interface StateMapper: Mapper<StateData, List<ActionData>, State>