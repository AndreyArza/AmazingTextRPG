package ru.andrey.demotextrpg.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.andrey.demotextrpg.database.DATABASE_NAME
import ru.andrey.demotextrpg.database.GameDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): GameDatabase = Room.databaseBuilder(
        context = context,
        klass = GameDatabase::class.java,
        name = DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideActionDao(database: GameDatabase) = database.actionDao()

    @Singleton
    @Provides
    fun provideDirectionDao(database: GameDatabase) = database.directionDao()

    @Singleton
    @Provides
    fun provideGameDao(database: GameDatabase) = database.gameDao()

    @Singleton
    @Provides
    fun provideLocationDao(database: GameDatabase) = database.locationDao()

    @Singleton
    @Provides
    fun provideModelDao(database: GameDatabase) = database.modelDao()

    @Singleton
    @Provides
    fun provideRelationActionToStatsDao(database: GameDatabase) =
        database.relationActionToStatsDao()

    @Singleton
    @Provides
    fun provideSideEffectDao(database: GameDatabase) = database.sideEffectDao()

    @Singleton
    @Provides
    fun provideStatDao(database: GameDatabase) = database.statDao()

    @Singleton
    @Provides
    fun provideStateDao(database: GameDatabase) = database.stateDao()

    @Singleton
    @Provides
    fun provideStatEventDao(database: GameDatabase) = database.statEventDao()

    @Singleton
    @Provides
    fun provideStatValueDao(database: GameDatabase) = database.statValueDao()

    @Singleton
    @Provides
    fun provideStatWithValueDao(database: GameDatabase) = database.statWithValueDao()
}