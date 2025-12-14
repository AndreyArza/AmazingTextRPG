package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

const val LOCATION_TABLE = "location_table"

@Entity(
    tableName = LOCATION_TABLE,
    primaryKeys = ["id", "gameId"],
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class LocationEntity(
    val id: String,
    val gameId: String,
    val defaultStateId: String,
    val description: String,
)