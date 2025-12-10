package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

const val DIRECTION_TABLE = "direction_table"

@Entity(
    tableName = DIRECTION_TABLE,
    primaryKeys = ["id", "gameId"],
    indices = [Index(value = ["locationId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DirectionEntity(
    val id: String,
    val gameId: String,
    val locationId: String,
    val name: String,
    val destinationId: String,
)