package ru.andrey.demotextrpg.network.di

import dagger.Module
import dagger.Provides
import ru.andrey.demotextrpg.network.api.implementation.NetworkApiImpl
import ru.andrey.demotextrpg.network.api.interfaces.NetworkApi
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkApi(): NetworkApi = NetworkApiImpl()
}