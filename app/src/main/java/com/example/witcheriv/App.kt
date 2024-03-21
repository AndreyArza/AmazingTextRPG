package com.example.witcheriv

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver

class App : Application(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
    }
    companion object {
        var appContext: Context? = null
    }
}