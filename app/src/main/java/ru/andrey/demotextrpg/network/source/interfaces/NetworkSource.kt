package ru.andrey.demotextrpg.network.source.interfaces

import kotlinx.coroutines.flow.Flow
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.Page
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData
import ru.andrey.demotextrpg.network.model.data.StateData
import ru.andrey.demotextrpg.network.model.request.CountData
import ru.andrey.demotextrpg.network.model.request.ItemType

interface NetworkSource {
    fun getGameAllGames(): Flow<Result<List<GameData>>>
    
    
    fun getActions(gameId: String, pageSize: Int): Flow<Result<Page<ActionData>>>
    fun getStates(gameId: String, pageSize: Int): Flow<Result<Page<StateData>>>
    fun getLocations(gameId: String, pageSize: Int): Flow<Result<Page<LocationData>>>
    fun getDirections(gameId: String, pageSize: Int): Flow<Result<Page<DirectionData>>>
    fun getStats(gameId: String, pageSize: Int): Flow<Result<Page<StatData>>>
    fun getStatsValues(gameId: String, pageSize: Int): Flow<Result<Page<StatValueData>>>
    fun getInitModel(gameId: String): Flow<Result<ModelData>>
}