package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

const val ACTION_TABLE = "action_table"


@Entity(
    tableName = ACTION_TABLE,
    primaryKeys = ["id", "gameId"],
    indices = [Index(value = ["stateId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]

)
data class ActionEntity(
    val id: String,
    val gameId: String,
    val stateId: String,
    val description: String,
)