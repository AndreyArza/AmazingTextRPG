package ru.andrey.demotextrpg.network.source.interfaces

import kotlinx.coroutines.flow.Flow
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.PageData
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData
import ru.andrey.demotextrpg.network.model.data.StateData

interface NetworkSource {
    fun getGames(pageSize: Int): Flow<Result<PageData<GameData>>>


    fun getActions(gameId: String, pageSize: Int): Flow<Result<PageData<ActionData>>>
    fun getStates(gameId: String, pageSize: Int): Flow<Result<PageData<StateData>>>
    fun getLocations(gameId: String, pageSize: Int): Flow<Result<PageData<LocationData>>>
    fun getDirections(gameId: String, pageSize: Int): Flow<Result<PageData<DirectionData>>>
    fun getStats(gameId: String, pageSize: Int): Flow<Result<PageData<StatData>>>
    fun getStatsValues(gameId: String, pageSize: Int): Flow<Result<PageData<StatValueData>>>
    fun getInitModel(gameId: String, gameVersion: String): Flow<Result<ModelData>>
}