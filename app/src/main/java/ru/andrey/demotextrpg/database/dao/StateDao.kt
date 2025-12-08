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
    @Query("SELECT * FROM $STATE_TABLE")
    fun getAll(): List<StateEntity>

    @Query("SELECT * FROM $STATE_TABLE WHERE id IN (:ids)")
    fun loadAllByIds(ids: List<String>): List<StateEntity>

    @Query("SELECT * FROM $STATE_TABLE WHERE gameId LIKE :id")
    fun loadAllByGameId(id: String): List<StateEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<StateEntity>)

    @Delete
    fun delete(entities: List<StateEntity>)
}