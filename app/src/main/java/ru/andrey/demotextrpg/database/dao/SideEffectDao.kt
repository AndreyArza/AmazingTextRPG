package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.SIDE_EFFECT_TABLE
import ru.andrey.demotextrpg.database.entities.SideEffectEntity

@Dao
interface SideEffectDao {
    @Query("SELECT * FROM $SIDE_EFFECT_TABLE WHERE actionId LIKE :id AND gameId LIKE :gameId")
    suspend fun loadAllByActionId(id: String, gameId: String): List<SideEffectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<SideEffectEntity>)

    @Delete
    suspend fun delete(entities: List<SideEffectEntity>)
}