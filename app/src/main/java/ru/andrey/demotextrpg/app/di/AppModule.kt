package ru.andrey.demotextrpg.app.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    fun bindContext(impl: Application): Context
}