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
    @Query("SELECT * FROM $LOCATION_TABLE WHERE id IN (:ids) AND  gameId LIKE :gameId")
    suspend fun loadAllByIds(gameId: String,ids: List<String>): List<LocationEntity>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE gameId LIKE :id")
    suspend fun loadAllByGameId(id: String): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<LocationEntity>)

    @Delete
    suspend fun delete(entities: List<LocationEntity>)
}