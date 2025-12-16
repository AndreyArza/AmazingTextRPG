package ru.andrey.demotextrpg.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.andrey.demotextrpg.database.DATABASE_NAME
import ru.andrey.demotextrpg.database.GameDatabase
import ru.andrey.demotextrpg.database.dao.di.DaoModule
import ru.andrey.demotextrpg.database.source.di.LocalSourceModule
import javax.inject.Singleton

@Module(
    includes = [
        DaoModule::class,
        LocalSourceModule::class
    ]
)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): GameDatabase = Room.databaseBuilder(
        context = context,
        klass = GameDatabase::class.java,
        name = DATABASE_NAME
    ).build()
}