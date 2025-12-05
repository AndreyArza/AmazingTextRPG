package ru.andrey.demotextrpg.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.andrey.demotextrpg.network.api.implementation.NetworkApiImpl
import ru.andrey.demotextrpg.network.api.interfaces.NetworkApi
import ru.andrey.demotextrpg.network.source.implementation.NetworkSourceImpl
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import javax.inject.Singleton

@Module
interface NetworkModule {
    @Singleton
    @Binds
    fun bindNetworkApi(impl: NetworkApiImpl): NetworkApi

    @Singleton
    @Binds
    fun bindNetworkSource(impl: NetworkSourceImpl): NetworkSource
}