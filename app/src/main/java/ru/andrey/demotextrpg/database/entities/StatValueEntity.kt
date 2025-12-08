package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.network.model.data.StatTypeData

const val STAT_VALUE_TABLE = "stat_value"

@Entity(
    tableName = STAT_VALUE_TABLE,
    indices = [Index(value = ["gameId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatValueEntity(
    @PrimaryKey
    val id: String,
    val gameId: String,
    val statId: String,
    val value: String = "",
    val type: StatTypeData = StatTypeData.STRING,
)