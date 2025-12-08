package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

const val STAT_TABLE = "stat_table"

@Entity(
    tableName = STAT_TABLE,
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatEntity(
    @PrimaryKey
    val id: String,
    val gameId: String,
    val name: String = "",
    val sortField: Int = Int.MAX_VALUE,
    val isVisible: Boolean = true,
)