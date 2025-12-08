package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

const val ACTION_TABLE = "action_table"


@Entity(
    tableName = ACTION_TABLE,
    indices = [Index(value = ["stateId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = StateEntity::class,
        parentColumns = ["id"],
        childColumns = ["stateId"],
        onDelete = ForeignKey.CASCADE
    )]

)
data class ActionEntity(
    @PrimaryKey
    val id: String,
    val stateId: String,
    val description: String,
)