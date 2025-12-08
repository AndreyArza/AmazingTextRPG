package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

const val STAT_WITH_VALUE_TABLE = "stat_with_value_table"


@Entity(
    tableName = STAT_WITH_VALUE_TABLE,
    primaryKeys = ["parentId", "statId", "valueId"],
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatWithValueEntity(
    val gameId: String,
    val parentId: String,
    val statId: String,
    val valueId: String,
)