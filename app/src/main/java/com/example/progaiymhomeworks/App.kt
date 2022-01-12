package com.example.progaiymhomeworks

import android.app.Application

class App: Application() {

    lateinit var pref: Preferences

    override fun onCreate() {
        super.onCreate()
        _instance = this
        pref = PreferencesImpl(this)
    }

    companion object {
        private var _instance: App? = null
        val instance get() = _instance!!
    }
}

val Any.Injector: App
    get() = App.instance