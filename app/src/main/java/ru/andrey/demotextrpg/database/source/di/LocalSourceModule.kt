package ru.andrey.demotextrpg.database.source.di

import dagger.Binds
import dagger.Module
import ru.andrey.demotextrpg.database.source.impementation.ActionLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.DirectionLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.GameLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.LocationLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.ModelLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.StatLocalSourceImpl
import ru.andrey.demotextrpg.database.source.impementation.StateLocalSourceImpl
import ru.andrey.demotextrpg.database.source.interfaces.ActionLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.DirectionLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.GameLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.LocationLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.ModelLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.StatLocalSource
import ru.andrey.demotextrpg.database.source.interfaces.StateLocalSource

@Module
interface LocalSourceModule {
    @Binds
    fun bindActionLocalSource(impl: ActionLocalSourceImpl): ActionLocalSource

    @Binds
    fun bindDirectionLocalSource(impl: DirectionLocalSourceImpl): DirectionLocalSource

    @Binds
    fun bindGameLocalSource(impl: GameLocalSourceImpl): GameLocalSource

    @Binds
    fun bindLocationLocalSource(impl: LocationLocalSourceImpl): LocationLocalSource

    @Binds
    fun bindModelLocalSource(impl: ModelLocalSourceImpl): ModelLocalSource

    @Binds
    fun bindStateLocalSource(impl: StateLocalSourceImpl): StateLocalSource

    @Binds
    fun bindStatLocalSource(impl: StatLocalSourceImpl): StatLocalSource
}