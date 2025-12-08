package ru.andrey.demotextrpg.app

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import ru.andrey.demotextrpg.app.di.ApplicationComponent
import ru.andrey.demotextrpg.app.di.DaggerApplicationComponent

class App : Application(), LifecycleObserver {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
    }

    companion object {
        var appContext: Context? = null
    }
}