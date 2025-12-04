package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ActionMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.SideEffectMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatsCheckMapper
import ru.andrey.demotextrpg.data.repository.model.Action

class ActionMapperImpl(
    val sideEffectMapper: SideEffectMapper = SideEffectMapperImpl(),
    val statsCheckMapper: StatsCheckMapper = StatsCheckMapperImpl()
) :
    ActionMapper {
    override fun map(
        data: ActionData,
        additionalInfo: ModelData?
    ): Action {
        return Action(
            id = data.id,
            description = data.description,
            sideEffect = sideEffectMapper.map(data.sideEffect),
            failSideEffect = sideEffectMapper.map(data.failSideEffect),
            isVisible = { model ->
                statsCheckMapper.map(data.visibilityCheckStatsWithValue, model.stats)
            },
            successCheck = { model ->
                val success =
                    statsCheckMapper.map(data.successCheck?.requiredStats?: listOf(), model.stats)
                val unsuccessful =
                    statsCheckMapper.map(data.successCheck?.unsuccessfulStats?: listOf(), model.stats)
                success && !unsuccessful
            },
        )
    }
}


