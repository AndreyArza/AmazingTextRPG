package ru.andrey.demotextrpg.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.andrey.demotextrpg.database.dao.ActionDao
import ru.andrey.demotextrpg.database.dao.DirectionDao
import ru.andrey.demotextrpg.database.dao.GameDao
import ru.andrey.demotextrpg.database.dao.LocationDao
import ru.andrey.demotextrpg.database.dao.ModelDao
import ru.andrey.demotextrpg.database.dao.RelationActionToStatsDao
import ru.andrey.demotextrpg.database.dao.RelationDirectionToStatsDao
import ru.andrey.demotextrpg.database.dao.RelationModelToStatsDao
import ru.andrey.demotextrpg.database.dao.SideEffectDao
import ru.andrey.demotextrpg.database.dao.StatDao
import ru.andrey.demotextrpg.database.dao.StatEventDao
import ru.andrey.demotextrpg.database.dao.StatValueDao
import ru.andrey.demotextrpg.database.dao.StateDao
import ru.andrey.demotextrpg.database.entities.DirectionEntity

const val DATABASE_NAME = "game_database"

@Database(entities = [DirectionEntity::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun actionDao(): ActionDao
    abstract fun directionDao(): DirectionDao
    abstract fun gameDao(): GameDao
    abstract fun locationDao(): LocationDao
    abstract fun modelDao(): ModelDao
    abstract fun relationActionToStatsDao(): RelationActionToStatsDao
    abstract fun relationDirectionToStatsDao(): RelationDirectionToStatsDao
    abstract fun relationModelToStatsDao(): RelationModelToStatsDao
    abstract fun sideEffectDao(): SideEffectDao
    abstract fun statDao(): StatDao
    abstract fun stateDao(): StateDao
    abstract fun statEventDao(): StatEventDao
    abstract fun statValueDao(): StatValueDao
}