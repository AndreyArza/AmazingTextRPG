package ru.andrey.demotextrpg.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.andrey.demotextrpg.database.dao.DirectionDao
import ru.andrey.demotextrpg.database.entities.DirectionEntity

const val DATABASE_NAME = "game_database"

@Database(entities = [DirectionEntity::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun userDao(): DirectionDao
}