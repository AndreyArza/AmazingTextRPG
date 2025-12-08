package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.DIRECTION_TABLE
import ru.andrey.demotextrpg.database.entities.DirectionEntity

@Dao
interface DirectionDao {
    @Query("SELECT * FROM $DIRECTION_TABLE")
    fun getAll(): List<DirectionEntity>

    @Query("SELECT * FROM $DIRECTION_TABLE WHERE id IN (:directionId)")
    fun loadAllByIds(directionId: List<String>): List<DirectionEntity>

    @Query("SELECT * FROM $DIRECTION_TABLE WHERE locationId in (:locationIds)")
    fun loadByLocationId(locationIds: List<String>): List<DirectionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg directions: DirectionEntity)

    @Delete
    fun delete(directions: List<DirectionEntity>)
}