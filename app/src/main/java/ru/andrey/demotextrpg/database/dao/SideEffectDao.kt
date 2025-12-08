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
    @Query("SELECT * FROM $SIDE_EFFECT_TABLE WHERE actionId in (:ids)")
    fun loadAllByActionIds(ids: List<String>): List<SideEffectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<SideEffectEntity>)

    @Delete
    fun delete(entities: List<SideEffectEntity>)
}