package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.database.custom_types.SideEffectType

const val SIDE_EFFECT_TABLE = "side_effect_table"

@Entity(
    tableName = SIDE_EFFECT_TABLE,
    indices = [Index(value = ["actionId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = ActionEntity::class,
        parentColumns = ["id"],
        childColumns = ["actionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class SideEffectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val actionId: String,
    val type: SideEffectType,
    val newStateId: String? = null,
    val newLocationId: String? = null,
)