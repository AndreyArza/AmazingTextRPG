package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.STAT_WITH_VALUE_TABLE
import ru.andrey.demotextrpg.database.entities.StatWithValueEntity

@Dao
interface StatWithValueDao {
    @Query("SELECT * FROM $STAT_WITH_VALUE_TABLE")
    suspend fun getAll(): List<StatWithValueEntity>

    @Query("SELECT * FROM $STAT_WITH_VALUE_TABLE WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: List<String>): List<StatWithValueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<StatWithValueEntity>)

    @Delete
    suspend fun delete(entities: List<StatWithValueEntity>)
}