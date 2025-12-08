package ru.andrey.demotextrpg.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.database.custom_types.TabData

const val GAME_TABLE = "game_table"

@Entity(tableName = GAME_TABLE)
data class GameEntity(
    @PrimaryKey
    val id: String,
    val version: String,
    val name: String,
    @Embedded(prefix = "location_")
    val locationTabInfo: TabData,
    @Embedded(prefix = "state_")
    val stateTabInfo: TabData,
    @Embedded(prefix = "stats_")
    val statsTabInfo: TabData
)