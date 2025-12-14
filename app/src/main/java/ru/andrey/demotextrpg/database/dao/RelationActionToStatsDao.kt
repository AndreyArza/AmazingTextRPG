package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.RELATION_ACTION_TO_STATS_TABLE
import ru.andrey.demotextrpg.database.entities.RelationActionToStatsEntity

@Dao
interface RelationActionToStatsDao {
    @Query("SELECT * FROM $RELATION_ACTION_TO_STATS_TABLE WHERE actionId LIKE :id AND gameId LIKE :gameId")
    suspend fun loadAllByActionIds(id: String, gameId: String): List<RelationActionToStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<RelationActionToStatsEntity>)

    @Delete
    suspend fun delete(entities: List<RelationActionToStatsEntity>)
}