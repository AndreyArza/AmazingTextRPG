package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.andrey.demotextrpg.network.model.data.StatTypeData

const val STAT_VALUE_TABLE = "stat_value"

@Entity(
    tableName = STAT_VALUE_TABLE
)
data class StatValueEntity(
    @PrimaryKey
    val id: String,
    val statId: String,
    val value: String = "",
    val type: StatTypeData = StatTypeData.STRING,
)