package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import ru.andrey.demotextrpg.database.custom_types.SideEffectType
import ru.andrey.demotextrpg.database.custom_types.StatEventType

const val STAT_EVENT_TABLE = "stat_event_table"


@Entity(
    tableName = STAT_EVENT_TABLE,
    indices = [Index(value = ["actionId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatEventEntity(
    val gameId: String,
    val actionId: String,
    val statId: String,
    val statValueId: String,
    val type: StatEventType,
    val effectType: SideEffectType,
)