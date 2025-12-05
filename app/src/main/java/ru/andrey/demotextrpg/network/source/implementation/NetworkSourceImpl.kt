package ru.andrey.demotextrpg.network.source.implementation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.andrey.demotextrpg.network.api.interfaces.NetworkApi
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.Page
import ru.andrey.demotextrpg.network.model.data.StatData
import ru.andrey.demotextrpg.network.model.data.StatValueData
import ru.andrey.demotextrpg.network.model.data.StateData
import ru.andrey.demotextrpg.network.model.request.ItemType
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import javax.inject.Inject

class NetworkSourceImpl @Inject constructor(
    private val api: NetworkApi
) : NetworkSource {
    private val scope = CoroutineScope(Dispatchers.IO)
    

    override fun getGameAllGames(): Flow<Result<List<GameData>>> {
        val flow = MutableSharedFlow<Result<List<GameData>>>()
        scope.launch {
            flow.tryEmit(api.getGameAllGames())
        }
        return flow
    }

    override fun getActions(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<ActionData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.ACTION,
            apiCall = { gameId, limit, offset ->
                api.getActions(gameId, limit, offset)
            }
        )
    }

    override fun getStates(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<StateData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STATE,
            apiCall = { gameId, limit, offset ->
                api.getStates(gameId, limit, offset)
            }
        )
    }

    override fun getLocations(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<LocationData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.LOCATION,
            apiCall = { gameId, limit, offset ->
                api.getLocations(gameId, limit, offset)
            }
        )
    }

    override fun getDirections(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<DirectionData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.DIRECTION,
            apiCall = { gameId, limit, offset ->
                api.getDirections(gameId, limit, offset)
            }
        )
    }

    override fun getStats(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<StatData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STAT,
            apiCall = { gameId, limit, offset ->
                api.getStats(gameId, limit, offset)
            }
        )
    }

    override fun getStatsValues(
        gameId: String,
        pageSize: Int
    ): Flow<Result<Page<StatValueData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STAT_VALUE,
            apiCall = { gameId, limit, offset ->
                api.getStatsValues(gameId, limit, offset)
            }
        )
    }

    override fun getInitModel(gameId: String): Flow<Result<ModelData>> {
        val flow = MutableSharedFlow<Result<ModelData>>()
        scope.launch {
            flow.tryEmit(api.getInitModel(gameId))
        }
        return flow
    }



    private fun <T> getData(
        gameId: String,
        pageSize: Int,
        itemType: ItemType,
        apiCall: suspend (gameId: String, limit: Int, offset: Int) -> Result<List<T>>
    ): Flow<Result<Page<T>>> {
        val flow = MutableSharedFlow<Result<Page<T>>>()
        scope.launch {
            try {
                val total = api.getItemsCount(gameId, itemType).getOrThrow().count
                var offset = 0
                var data = apiCall.invoke(gameId, pageSize, offset)
                while (offset < total) {
                    flow.tryEmit(data.map { list ->
                        Page(
                            values = list,
                            loaded = offset + pageSize,
                            total = total
                        )
                    })
                    offset += pageSize
                    data = apiCall.invoke(gameId, pageSize, offset)
                }
            } catch (e: Exception) {
                flow.tryEmit(Result.failure(e))
            }
        }
        return flow
    }
}