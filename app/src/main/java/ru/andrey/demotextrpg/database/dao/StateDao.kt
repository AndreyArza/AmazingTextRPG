package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.STATE_TABLE
import ru.andrey.demotextrpg.database.entities.StateEntity

@Dao
interface StateDao {
    @Query("SELECT * FROM $STATE_TABLE WHERE gameId LIKE :gameId")
    suspend fun getAllByGameId(gameId: String): List<StateEntity>

    @Query("SELECT * FROM $STATE_TABLE WHERE id IN (:ids) AND gameId LIKE :gameId")
    suspend fun loadAllByIds(ids: List<String>, gameId: String): List<StateEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<StateEntity>)

    @Delete
    suspend fun delete(entities: List<StateEntity>)
}