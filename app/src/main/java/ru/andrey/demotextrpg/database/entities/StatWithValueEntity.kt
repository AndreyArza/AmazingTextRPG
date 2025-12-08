package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity

const val STAT_WITH_VALUE_TABLE = "stat_with_value_table"


@Entity(
    tableName = STAT_WITH_VALUE_TABLE,
    primaryKeys = ["parentId", "statId", "valueId"]
)
data class StatWithValueEntity(
    val parentId: String,
    val statId: String,
    val valueId: String,
)