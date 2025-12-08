package ru.andrey.demotextrpg.data.repository.implementation

import ru.andrey.demotextrpg.logic.interfaces.Repository

class RepositoryImpl : Repository {
//    private val context get() = App.Companion.appContext
////    private lateinit var model: Model
////    private const val KEY_GAME = "GAME"
//
//
//
//
//    override fun getModel(): Model {
//        val allGame = getRawGame()
//        val allNewGame = getNewRawGame()
//        setModel(allGame.initModel.transform(allGame.allStats, allGame.allStatsValues))
//        return allGame.initModel.transform(allGame.allStats, allGame.allStatsValues)
//    }
//
//    override fun setModel(model: Model) {
//        val statsValues = mutableListOf<String>()
//        model.info.stats.values.forEach{stat ->
//                statsValues.addAll(stat.values.map { it.id })
//        }
//        val rawModel = DeprecatedModelData(
//            locationId = model.locationId,
//            stateId = model.stateId,
//            info = DeprecatedInfoData(
//                statsValuesIds = statsValues,
//                hiddenFlagsIds = model.info.hiddenFlagsIds.toList()
//            )
//
//        )
//    }
//
//    private fun getRawGame(): DeprecatedGameData {
//        val jsonString = game
//        return Json.Default.decodeFromString(jsonString)
//    }
//
//    private fun getNewRawGame(): GameData1 {
//        val jsonString = newGame
//        val res = Json.decodeFromString<GameData1>(jsonString)
//
//        return res
//    }
//
//    override fun getGame(): Game {
//        return getRawGame().transform()
//    }
//

}