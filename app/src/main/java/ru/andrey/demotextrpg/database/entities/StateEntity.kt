package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

const val STATE_TABLE = "state_table"

@Entity(
    tableName = STATE_TABLE,
    primaryKeys = ["id", "gameId"],
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StateEntity(
    val id: String,
    val gameId: String,
    val description: String,
)