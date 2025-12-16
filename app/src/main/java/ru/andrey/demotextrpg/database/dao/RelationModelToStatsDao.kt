package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.RELATION_MODEL_TO_STATS_TABLE
import ru.andrey.demotextrpg.database.entities.RelationModelToStatsEntity

@Dao
interface RelationModelToStatsDao {
    @Query("SELECT * FROM $RELATION_MODEL_TO_STATS_TABLE WHERE gameId LIKE :gameId")
    suspend fun loadAllByGameId(gameId: String): List<RelationModelToStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<RelationModelToStatsEntity>)

    @Delete
    suspend fun delete(entities: List<RelationModelToStatsEntity>)
}