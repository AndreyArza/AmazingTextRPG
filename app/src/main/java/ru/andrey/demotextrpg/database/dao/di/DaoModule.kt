package ru.andrey.demotextrpg.database.dao.di

import dagger.Module
import dagger.Provides
import ru.andrey.demotextrpg.database.GameDatabase
import javax.inject.Singleton

@Module
class DaoModule {
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
    fun provideRelationDirectionToStatsDao(database: GameDatabase) =
        database.relationDirectionToStatsDao()

    @Singleton
    @Provides
    fun provideRelationModelToStatsDao(database: GameDatabase) =
        database.relationModelToStatsDao()

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
}