package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.GAME_TABLE
import ru.andrey.demotextrpg.database.entities.GameEntity

@Dao
interface GameDao {
    @Query("SELECT * FROM $GAME_TABLE")
    suspend fun getAll(): List<GameEntity>

    @Query("SELECT * FROM $GAME_TABLE WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: List<String>): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<GameEntity>)

    @Delete
    suspend fun delete(games: List<GameEntity>)
}