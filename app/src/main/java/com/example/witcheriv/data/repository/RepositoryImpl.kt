package com.example.witcheriv.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.witcheriv.App
import com.example.witcheriv.data.game
import com.example.witcheriv.data.model.ModelData
import com.example.witcheriv.logic.data.Model
import com.example.witcheriv.data.model.GameData
import com.example.witcheriv.logic.data.Game
import com.example.witcheriv.data.model.InfoData
import com.example.witcheriv.logic.interfaces.Repository
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object RepositoryImpl : Repository {
    private val preferences: SharedPreferences?
    private val context get() = App.appContext
    private const val KEY_MODEL = "MODEL"
    private const val KEY_GAME = "GAME"


    init {
        val sharedPrefName = context?.packageName + "_preferences"
        preferences = context?.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
    }

    override fun getModel(): Model {
        val jsonString =
            preferences?.getString(KEY_MODEL, null) ?: Json.encodeToString(getRawGame().initModel)
        val model: ModelData = Json.decodeFromString(jsonString)
        val allGame = getRawGame()
        setModel(model.transform(allGame.allStats, allGame.allStatsValues))
        return model.transform(allGame.allStats, allGame.allStatsValues)
    }

    override fun setModel(model: Model) {
        val statsValues = mutableListOf<String>()
        model.info.stats.values.forEach{stat ->
                statsValues.addAll(stat.values.map { it.id })
        }
        val rawModel = ModelData(
            locationId = model.locationId,
            stateId = model.stateId,
            info = InfoData(
                statsValuesIds = statsValues,
                hiddenFlagsIds = model.info.hiddenFlagsIds.toList()
            )

        )
        preferences?.edit()?.putString(KEY_MODEL, Json.encodeToString(rawModel))?.apply()
    }

    private fun getRawGame(): GameData {
        val jsonString = preferences?.getString(KEY_GAME, null)
            ?: game
        preferences?.edit()?.putString(KEY_GAME, jsonString)?.apply()
        return Json.decodeFromString(jsonString)
    }

    override fun getGame(): Game {
        return getRawGame().transform()
    }


}
