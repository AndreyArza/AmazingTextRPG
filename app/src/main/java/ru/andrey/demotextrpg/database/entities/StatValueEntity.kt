package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import ru.andrey.demotextrpg.database.custom_types.StatType

const val STAT_VALUE_TABLE = "stat_value"

@Entity(
    tableName = STAT_VALUE_TABLE,
    primaryKeys = ["id", "gameId"],
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatValueEntity(
    val id: String,
    val gameId: String,
    val statId: String,
    val value: String = "",
    val type: StatType = StatType.STRING,
)