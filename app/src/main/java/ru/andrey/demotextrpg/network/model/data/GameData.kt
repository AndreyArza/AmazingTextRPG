package ru.andrey.demotextrpg.network.model.data

import kotlinx.serialization.Serializable

@Serializable
data class GameData(
    val id: String,
    val version: String,
    val name: String,
    val locationTabInfo: TabData,
    val stateTabInfo: TabData,
    val statsTabInfo: TabData
)


