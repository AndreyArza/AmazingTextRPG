package ru.andrey.demotextrpg.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.andrey.demotextrpg.database.entities.RELATION_DIRECTION_TO_STATS_TABLE
import ru.andrey.demotextrpg.database.entities.RelationDirectionToStatsEntity

@Dao
interface RelationDirectionToStatsDao {
    @Query("SELECT * FROM $RELATION_DIRECTION_TO_STATS_TABLE WHERE directionId LIKE :id AND gameId LIKE :gameId")
    suspend fun loadAllByDirectionId(id: String, gameId: String): List<RelationDirectionToStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<RelationDirectionToStatsEntity>)

    @Delete
    suspend fun delete(entities: List<RelationDirectionToStatsEntity>)
}