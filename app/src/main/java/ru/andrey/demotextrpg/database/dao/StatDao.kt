package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.STAT_TABLE
import ru.andrey.demotextrpg.database.entities.StatEntity

@Dao
interface StatDao {
    @Query("SELECT * FROM $STAT_TABLE")
    fun getAll(): List<StatEntity>

    @Query("SELECT * FROM $STAT_TABLE WHERE id IN (:ids)")
    fun loadAllByIds(ids: List<String>): List<StatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<StatEntity>)

    @Delete
    fun delete(entities: List<StatEntity>)
}