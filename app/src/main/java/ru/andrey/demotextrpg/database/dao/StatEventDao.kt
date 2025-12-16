package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.custom_types.SideEffectType
import ru.andrey.demotextrpg.database.entities.STAT_EVENT_TABLE
import ru.andrey.demotextrpg.database.entities.StatEventEntity

@Dao
interface StatEventDao {
    @Query(
        "SELECT * FROM $STAT_EVENT_TABLE WHERE effectType LIKE :sideEffectType " +
                "AND gameId LIKE :gameId AND actionId LIKE :actionId"
    )
    suspend fun loadAllBySideEffect(
        actionId: String,
        sideEffectType: SideEffectType,
        gameId: String
    ): List<StatEventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<StatEventEntity>)

    @Delete
    suspend fun delete(entities: List<StatEventEntity>)
}