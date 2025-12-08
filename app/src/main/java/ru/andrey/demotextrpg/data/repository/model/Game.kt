package ru.andrey.demotextrpg.data.repository.model

data class Game(
    val id: String,
    val version: String,
    val name: String,
    val locationTabInfo: TabInfo,
    val stateTabInfo: TabInfo,
    val statsTabInfo: TabInfo
)