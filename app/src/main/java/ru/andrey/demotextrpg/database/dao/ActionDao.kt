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
    @Query("SELECT * FROM $ACTION_TABLE WHERE gameId LIKE :gameId")
    suspend fun getAllByGameId(gameId: String): List<ActionEntity>

    @Query("SELECT * FROM $ACTION_TABLE WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: List<String>): List<ActionEntity>

    @Query("SELECT * FROM $ACTION_TABLE WHERE stateId LIKE :id AND gameId LIKE :gameId")
    suspend fun loadAllByStateId(id: String, gameId: String): List<ActionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<ActionEntity>)

    @Delete
    suspend fun delete(entities: List<ActionEntity>)
}