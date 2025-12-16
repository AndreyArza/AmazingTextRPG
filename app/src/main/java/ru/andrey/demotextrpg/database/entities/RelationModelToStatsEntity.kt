package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

const val RELATION_MODEL_TO_STATS_TABLE = "relation_model_to_stats_table"

@Entity(
    tableName = RELATION_MODEL_TO_STATS_TABLE,
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RelationModelToStatsEntity(
    val gameId: String,
    val statId: String,
    val valueId: String,
)