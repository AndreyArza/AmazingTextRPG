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
    @Query("SELECT * FROM $RELATION_ACTION_TO_STATS_TABLE WHERE actionId in (:ids)")
    fun loadAllByActionIds(ids: List<String>): List<RelationActionToStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<RelationActionToStatsEntity>)

    @Delete
    fun delete(entities: List<RelationActionToStatsEntity>)
}