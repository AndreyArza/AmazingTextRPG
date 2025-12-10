package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.andrey.demotextrpg.database.entities.MODEL_TABLE
import ru.andrey.demotextrpg.database.entities.ModelEntity


@Dao
interface ModelDao {
    @Query("SELECT * FROM $MODEL_TABLE")
    suspend fun getAll(): List<ModelEntity>

    @Query("SELECT * FROM $MODEL_TABLE WHERE gameId LIKE :id")
    suspend fun loadByGameId(id: String): Flow<ModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<ModelEntity>)

    @Delete
    suspend fun delete(entities: List<ModelEntity>)
}