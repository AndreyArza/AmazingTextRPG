package ru.andrey.demotextrpg.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.andrey.demotextrpg.database.di.DatabaseModule
import ru.andrey.demotextrpg.network.di.NetworkModule
import ru.andrey.demotextrpg.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}