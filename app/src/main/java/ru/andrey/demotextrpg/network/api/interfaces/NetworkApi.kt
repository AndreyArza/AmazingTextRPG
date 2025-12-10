package ru.andrey.demotextrpg.network.api.interfaces

import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData
import ru.andrey.demotextrpg.network.model.data.StateData
import ru.andrey.demotextrpg.network.model.request.CountData
import ru.andrey.demotextrpg.network.model.request.ItemType

interface NetworkApi {
    suspend fun getGames(limit: Int, offset: Int): Result<List<GameData>>

    /*For type "GAME" gameId ignored*/
    suspend fun getItemsCount(gameId: String, itemType: ItemType): Result<CountData>
    suspend fun getActions(gameId: String, limit: Int, offset: Int): Result<List<ActionData>>
    suspend fun getStates(gameId: String, limit: Int, offset: Int): Result<List<StateData>>
    suspend fun getLocations(gameId: String, limit: Int, offset: Int): Result<List<LocationData>>
    suspend fun getDirections(gameId: String, limit: Int, offset: Int): Result<List<DirectionData>>
    suspend fun getStats(gameId: String, limit: Int, offset: Int): Result<List<StatData>>
    suspend fun getStatsValues(gameId: String, limit: Int, offset: Int): Result<List<StatValueData>>
    suspend fun getInitModel(gameId: String, gameVersion: String): Result<ModelData>
}