package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.network.model.data.StatEventTypeData

const val STAT_EVENT_TABLE = "stat_event_table"


@Entity(
    tableName = STAT_EVENT_TABLE,
    indices = [Index(value = ["sideEffectId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = SideEffectEntity::class,
        parentColumns = ["id"],
        childColumns = ["sideEffectId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StatEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val sideEffectId: String,
    val statId: String,
    val statValueId: String,
    val type: StatEventTypeData,
)