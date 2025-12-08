package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import ru.andrey.demotextrpg.database.custom_types.RelationActionToStatsType

const val RELATION_ACTION_TO_STATS_TABLE = "relation_action_to_stats_table"


@Entity(
    tableName = RELATION_ACTION_TO_STATS_TABLE,
    primaryKeys = ["actionId", "statId", "valueId", "type"],
    foreignKeys = [ForeignKey(
        entity = ActionEntity::class,
        parentColumns = ["id"],
        childColumns = ["actionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RelationActionToStatsEntity(
    val actionId: String,
    val statId: String,
    val valueId: String,
    val type: RelationActionToStatsType
)