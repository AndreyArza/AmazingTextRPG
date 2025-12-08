package ru.andrey.demotextrpg.network.source.implementation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.andrey.demotextrpg.network.api.interfaces.NetworkApi
import ru.andrey.demotextrpg.network.model.data.ActionData
import ru.andrey.demotextrpg.network.model.data.DirectionData
import ru.andrey.demotextrpg.network.model.data.GameData
import ru.andrey.demotextrpg.network.model.data.LocationData
import ru.andrey.demotextrpg.network.model.data.ModelData
import ru.andrey.demotextrpg.network.model.data.PageData
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

    override fun getGames(pageSize: Int): Flow<Result<PageData<GameData>>> {
        return getData(
            gameId = "",
            pageSize = pageSize,
            itemType = ItemType.ACTION,
            apiCall = { limit, offset ->
                api.getGames(limit, offset)
            }
        )
    }

    override fun getActions(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<ActionData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.ACTION,
            apiCall = { limit, offset ->
                api.getActions(gameId, limit, offset)
            }
        )
    }

    override fun getStates(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<StateData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STATE,
            apiCall = { limit, offset ->
                api.getStates(gameId, limit, offset)
            }
        )
    }

    override fun getLocations(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<LocationData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.LOCATION,
            apiCall = { limit, offset ->
                api.getLocations(gameId, limit, offset)
            }
        )
    }

    override fun getDirections(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<DirectionData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.DIRECTION,
            apiCall = { limit, offset ->
                api.getDirections(gameId, limit, offset)
            }
        )
    }

    override fun getStats(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<StatData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STAT,
            apiCall = { limit, offset ->
                api.getStats(gameId, limit, offset)
            }
        )
    }

    override fun getStatsValues(
        gameId: String,
        pageSize: Int
    ): Flow<Result<PageData<StatValueData>>> {
        return getData(
            gameId = gameId,
            pageSize = pageSize,
            itemType = ItemType.STAT_VALUE,
            apiCall = { limit, offset ->
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
        apiCall: suspend (limit: Int, offset: Int) -> Result<List<T>>
    ): Flow<Result<PageData<T>>> {
        val flow =
            MutableStateFlow<Result<PageData<T>>>(
                Result.success(
                    PageData(
                        emptyList(),
                        0,
                        Int.MAX_VALUE
                    )
                )
            )
        scope.launch {
            try {
                val total = api.getItemsCount(gameId, itemType).getOrThrow().count
                var offset = 0
                var data = apiCall.invoke(pageSize, offset)
                while (offset < total) {
                    flow.update { old ->
                        data.map { list ->
                            PageData(
                                values = old.getOrThrow().values + list,
                                loaded = offset + pageSize,
                                total = total
                            )
                        }
                    }
                    offset += pageSize
                    data = apiCall.invoke(pageSize, offset)
                }
            } catch (e: Exception) {
                flow.tryEmit(Result.failure(e))
            }
        }
        return flow
    }
}