package ru.andrey.demotextrpg.app.di

import dagger.Component
import jakarta.inject.Singleton
import ru.andrey.demotextrpg.data.di.DataModule
import ru.andrey.demotextrpg.ui.activity.MainActivity

@Singleton
@Component(modules = [DataModule::class])
interface ApplicationComponent {
//    fun inject(activity: MainActivity)
}