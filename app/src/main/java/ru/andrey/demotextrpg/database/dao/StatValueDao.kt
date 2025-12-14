package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.STAT_VALUE_TABLE
import ru.andrey.demotextrpg.database.entities.StatValueEntity

@Dao
interface StatValueDao {
    @Query("SELECT * FROM $STAT_VALUE_TABLE WHERE gameId LIKE :gameId")
    suspend fun getAllByGameId(gameId: String): List<StatValueEntity>

    @Query("SELECT * FROM $STAT_VALUE_TABLE WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: List<String>): List<StatValueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<StatValueEntity>)

    @Delete
    suspend fun delete(entities: List<StatValueEntity>)
}