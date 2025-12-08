package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.LOCATION_TABLE
import ru.andrey.demotextrpg.database.entities.LocationEntity

@Dao
interface LocationDao {
    @Query("SELECT * FROM $LOCATION_TABLE")
    fun getAll(): List<LocationEntity>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE id IN (:ids)")
    fun loadAllByIds(ids: List<String>): List<LocationEntity>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE gameId LIKE :id")
    fun loadAllByGameId(id: String): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<LocationEntity>)

    @Delete
    fun delete(entities: List<LocationEntity>)
}