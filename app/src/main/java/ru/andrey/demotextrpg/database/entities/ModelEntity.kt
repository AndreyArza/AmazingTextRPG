package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.network.model.data.StatWithValueData

const val MODEL_TABLE = "model_table"


@Entity(
    tableName = MODEL_TABLE,
    foreignKeys = [ForeignKey(
        entity = GameEntity::class,
        parentColumns = ["id"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ModelEntity(
    @PrimaryKey
    val gameId: String,
    val locationId: String,
    val stateId: String,
    val statsWithValuesIds: List<StatWithValueData>,
)
