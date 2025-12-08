package ru.andrey.demotextrpg.database.source.impementation

import android.content.Context
import androidx.room.Room
import ru.andrey.demotextrpg.database.DATABASE_NAME
import ru.andrey.demotextrpg.database.GameDatabase
import ru.andrey.demotextrpg.database.source.interfaces.DatabaseSource
import javax.inject.Inject

class DatabaseSourceImpl @Inject constructor(
    applicationContext: Context
) : DatabaseSource {
    //TODO: Provide by dagger???
    private val database = Room.databaseBuilder(
        context = applicationContext,
        klass = GameDatabase::class.java,
        name = DATABASE_NAME
    ).build()
}