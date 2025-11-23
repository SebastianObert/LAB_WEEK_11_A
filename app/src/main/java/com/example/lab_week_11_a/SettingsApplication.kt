package com.example.lab_week_11_a

import android.app.Application

class SettingsApplication : Application() {
    lateinit var settingsStore: SettingsStore
    override fun onCreate() {
        super.onCreate()
        // Inisialisasi settings store
        settingsStore = SettingsStore(this)
    }
}