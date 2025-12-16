package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ActionMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StateMapper
import ru.andrey.demotextrpg.domain.model.State
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.StateData

class StateMapperImpl(
    val actionMapper: ActionMapper = ActionMapperImpl()
) : StateMapper {
    override fun map(
        data: StateData,
        additionalInfo: List<ActionData>?
    ): State {
        val actions = additionalInfo?.filter { it.parentStateId == data.id } ?: listOf()
        return State(
            id = data.id,
            description = data.description,
            actions = actions.map { actionMapper.map(it) }
        )
    }
}