package ru.andrey.demotextrpg.database.model

data class GameLocal(
    val id: String,
    val version: String,
    val name: String,
    val locationTabInfo: TabLocal,
    val stateTabInfo: TabLocal,
    val statsTabInfo: TabLocal
)


