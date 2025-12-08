package ru.andrey.demotextrpg.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

const val DIRECTION_TABLE = "direction_table"

@Entity(
    tableName = DIRECTION_TABLE,
    indices = [Index(value = ["locationId"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["locationId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DirectionEntity(
    @PrimaryKey
    val id: String,
    val locationId: String,
    val name: String,
    val destinationId: String,
)