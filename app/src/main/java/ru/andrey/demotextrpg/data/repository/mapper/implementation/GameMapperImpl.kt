package ru.andrey.demotextrpg.data.repository.mapper.implementation

import ru.andrey.demotextrpg.network.model.data.GameData1
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ActionMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.DirectionMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.GameMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.LocationMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.ModelMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StatValueMapper
import ru.andrey.demotextrpg.data.repository.mapper.interfaces.StateMapper
import ru.andrey.demotextrpg.data.repository.model.Game

class GameMapperImpl(
    val actionMapper: ActionMapper = ActionMapperImpl(),
    val stateMapper: StateMapper = StateMapperImpl(),
    val locationMapper: LocationMapper = LocationMapperImpl(),
    val directionMapper: DirectionMapper = DirectionMapperImpl(),
    val statMapper: StatMapper = StatMapperImpl(),
    val statValueMapper: StatValueMapper = StatValueMapperImpl(),
    val modelMapper: ModelMapper = ModelMapperImpl()
) : GameMapper {
    override fun map(
        data: GameData1,
        additionalInfo: Unit?
    ): Game {
        return Game(
            allActions = data.allActions.map { actionMapper.map(it) }.associateBy { it.id },
            allStates = data.allStates.map { stateMapper.map(it) }.associateBy { it.id },
            allLocations = data.allLocations.map { locationMapper.map(it) }.associateBy { it.id },
            allDirections = data.allDirections.map { directionMapper.map(it) }
                .associateBy { it.id },
            allStats = data.allStats.map { statMapper.map(it) }.associateBy { it.id },
            allStatsValues = data.allStatsValues.map { statValueMapper.map(it) }
                .associateBy { it.id },
            initModel = modelMapper.map(data.initModel)
        )
    }
}