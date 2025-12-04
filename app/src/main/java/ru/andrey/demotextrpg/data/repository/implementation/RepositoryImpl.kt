package ru.andrey.demotextrpg.data.repository.implementation

import kotlinx.serialization.json.Json
import ru.andrey.demotextrpg.app.App
import ru.andrey.demotextrpg.data.game
import ru.andrey.demotextrpg.network.model.data.DeprecatedGameData
import ru.andrey.demotextrpg.network.model.data.DeprecatedInfoData
import ru.andrey.demotextrpg.network.model.data.DeprecatedModelData
import ru.andrey.demotextrpg.network.model.data.GameData1
import ru.andrey.demotextrpg.data.newGame
import ru.andrey.demotextrpg.logic.data.Game
import ru.andrey.demotextrpg.logic.data.Model
import ru.andrey.demotextrpg.logic.interfaces.Repository

class RepositoryImpl : Repository {
    private val context get() = App.Companion.appContext
//    private lateinit var model: Model
//    private const val KEY_GAME = "GAME"




    override fun getModel(): Model {
        val allGame = getRawGame()
        val allNewGame = getNewRawGame()
        setModel(allGame.initModel.transform(allGame.allStats, allGame.allStatsValues))
        return allGame.initModel.transform(allGame.allStats, allGame.allStatsValues)
    }

    override fun setModel(model: Model) {
        val statsValues = mutableListOf<String>()
        model.info.stats.values.forEach{stat ->
                statsValues.addAll(stat.values.map { it.id })
        }
        val rawModel = DeprecatedModelData(
            locationId = model.locationId,
            stateId = model.stateId,
            info = DeprecatedInfoData(
                statsValuesIds = statsValues,
                hiddenFlagsIds = model.info.hiddenFlagsIds.toList()
            )

        )
    }

    private fun getRawGame(): DeprecatedGameData {
        val jsonString = game
        return Json.Default.decodeFromString(jsonString)
    }

    private fun getNewRawGame(): GameData1 {
        val jsonString = newGame
        val res = Json.decodeFromString<GameData1>(jsonString)

        return res
    }

    override fun getGame(): Game {
        return getRawGame().transform()
    }


}