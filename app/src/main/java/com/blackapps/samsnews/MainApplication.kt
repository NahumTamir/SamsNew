package com.blackapps.samsnews

import android.app.Application
import android.content.Context

class MainApplication : Application() {
    companion object {
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

    }
}

