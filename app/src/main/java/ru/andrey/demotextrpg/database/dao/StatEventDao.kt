package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.STAT_EVENT_TABLE
import ru.andrey.demotextrpg.database.entities.StatEventEntity

@Dao
interface StatEventDao {
    @Query("SELECT * FROM $STAT_EVENT_TABLE")
    suspend fun getAll(): List<StatEventEntity>

    @Query("SELECT * FROM $STAT_EVENT_TABLE WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: List<String>): List<StatEventEntity>

    @Query("SELECT * FROM $STAT_EVENT_TABLE WHERE sideEffectId in (:ids)")
    suspend fun loadAllBySideEffectIds(ids: List<String>): List<StatEventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<StatEventEntity>)

    @Delete
    suspend fun delete(entities: List<StatEventEntity>)
}