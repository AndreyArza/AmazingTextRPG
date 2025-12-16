package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import ru.andrey.demotextrpg.database.custom_types.SideEffectType

const val SIDE_EFFECT_TABLE = "side_effect_table"

@Entity(
    tableName = SIDE_EFFECT_TABLE,
    indices = [Index(value = ["actionId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class SideEffectEntity(
    val gameId: String,
    val actionId: String,
    val type: SideEffectType,
    val newStateId: String? = null,
    val newLocationId: String? = null,
)