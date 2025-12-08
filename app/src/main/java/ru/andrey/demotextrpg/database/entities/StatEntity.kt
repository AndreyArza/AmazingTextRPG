package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val STAT_TABLE = "stat_table"

@Entity(
    tableName = STAT_TABLE
)
data class StatEntity(
    @PrimaryKey
    val id: String,
    val name: String = "",
    val sortField: Int = Int.MAX_VALUE,
    val isVisible: Boolean = true,
)