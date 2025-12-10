package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import ru.andrey.demotextrpg.database.custom_types.RelationActionToStatsType

const val RELATION_ACTION_TO_STATS_TABLE = "relation_action_to_stats_table"


@Entity(
    tableName = RELATION_ACTION_TO_STATS_TABLE,
    foreignKeys = [ForeignKey(
        entity = ActionEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RelationActionToStatsEntity(
    val gameId: String,
    val actionId: String,
    val statId: String,
    val valueId: String,
    val type: RelationActionToStatsType
)