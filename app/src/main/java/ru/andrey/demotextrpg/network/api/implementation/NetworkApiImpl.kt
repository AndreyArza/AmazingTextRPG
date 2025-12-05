package ru.andrey.demotextrpg.network.api.implementation

import jakarta.inject.Inject
import kotlinx.serialization.json.Json
import ru.andrey.demotextrpg.network.api.interfaces.NetworkApi
import ru.andrey.demotextrpg.network.mock.actions
import ru.andrey.demotextrpg.network.mock.directions
import ru.andrey.demotextrpg.network.mock.game
import ru.andrey.demotextrpg.network.mock.locations
import ru.andrey.demotextrpg.network.mock.model
import ru.andrey.demotextrpg.network.mock.states
import ru.andrey.demotextrpg.network.mock.stats
import ru.andrey.demotextrpg.network.mock.values
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

class NetworkApiImpl @Inject constructor() : NetworkApi {
    private val json = Json

    override suspend fun getGameAllGames(): Result<List<GameData>> {

        return Result.success(json.decodeFromString<List<GameData>>(game))
    }

    override suspend fun getItemsCount(
        gameId: String,
        itemType: ItemType
    ): Result<CountData> {
        val res =
            when (itemType) {
                ItemType.GAME -> json.decodeFromString<List<GameData>>(game).count()
                ItemType.ACTION -> json.decodeFromString<List<ActionData>>(actions).count()
                ItemType.DIRECTION -> json.decodeFromString<List<DirectionData>>(directions).count()
                ItemType.LOCATION -> json.decodeFromString<List<LocationData>>(locations).count()
                ItemType.STAT -> json.decodeFromString<List<StatData>>(stats).count()
                ItemType.STATE -> json.decodeFromString<List<StateData>>(states).count()
                ItemType.STAT_VALUE -> json.decodeFromString<List<StatValueData>>(values).count()
            }
        return Result.success(CountData(res))
    }

    override suspend fun getActions(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<ActionData>> {
        val list = json.decodeFromString<List<ActionData>>(actions)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getStates(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<StateData>> {
        val list = json.decodeFromString<List<StateData>>(states)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getLocations(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<LocationData>> {
        val list = json.decodeFromString<List<LocationData>>(locations)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getDirections(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<DirectionData>> {
        val list = json.decodeFromString<List<DirectionData>>(directions)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getStats(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<StatData>> {
        val list = json.decodeFromString<List<StatData>>(stats)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getStatsValues(
        gameId: String,
        limit: Int,
        offset: Int
    ): Result<List<StatValueData>> {
        val list = json.decodeFromString<List<StatValueData>>(values)
        return Result.success(
            list.getElementsFromOffset(
                limit = limit,
                offset = offset
            )
        )
    }

    override suspend fun getInitModel(
        gameId: String
    ): Result<ModelData> {
        val model = json.decodeFromString<ModelData>(model)
        return Result.success(model)
    }

    private fun <T> List<T>.getElementsFromOffset(offset: Int, limit: Int): List<T> {
        return this.drop(offset).take(limit)
    }
}