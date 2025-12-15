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
    @Query("SELECT * FROM $DIRECTION_TABLE WHERE gameId LIKE :gameId")
    suspend fun getAllByGameId(gameId: String): List<DirectionEntity>

    @Query("SELECT * FROM $DIRECTION_TABLE WHERE id IN (:directionId) AND gameId LIKE :gameId")
    suspend fun loadAllByIds(directionId: List<String>, gameId: String): List<DirectionEntity>

    @Query("SELECT * FROM $DIRECTION_TABLE WHERE locationId in (:locationIds) AND gameId LIKE :gameId")
    suspend fun loadByLocationId(locationIds: List<String>, gameId: String): List<DirectionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg directions: List<DirectionEntity>)

    @Delete
    suspend fun delete(directions: List<DirectionEntity>)
}