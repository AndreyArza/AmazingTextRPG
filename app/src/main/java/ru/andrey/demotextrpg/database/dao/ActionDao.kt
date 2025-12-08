package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.ACTION_TABLE
import ru.andrey.demotextrpg.database.entities.ActionEntity

@Dao
interface ActionDao {
    @Query("SELECT * FROM $ACTION_TABLE")
    fun getAll(): List<ActionEntity>

    @Query("SELECT * FROM $ACTION_TABLE WHERE id IN (:ids)")
    fun loadAllByIds(ids: List<String>): List<ActionEntity>

    @Query("SELECT * FROM $ACTION_TABLE WHERE stateId in (:ids)")
    fun loadAllByStateIds(ids: List<String>): List<ActionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<ActionEntity>)

    @Delete
    fun delete(entities: List<ActionEntity>)
}