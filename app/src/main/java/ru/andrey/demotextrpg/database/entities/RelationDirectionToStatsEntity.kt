package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

const val RELATION_DIRECTION_TO_STATS_TABLE = "relation_direction_to_stats_table"

@Entity(
    tableName = RELATION_DIRECTION_TO_STATS_TABLE,
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RelationDirectionToStatsEntity(
    val gameId: String,
    val directionId: String,
    val statId: String,
    val valueId: String,
)