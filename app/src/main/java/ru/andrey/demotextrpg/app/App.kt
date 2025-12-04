package ru.andrey.demotextrpg.app

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import ru.andrey.demotextrpg.DaggerApplicationComponent

class App : Application(), LifecycleObserver {

    val appComponent = DaggerApplicationComponent.create()
    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
    }
    companion object {
        var appContext: Context? = null
    }
}