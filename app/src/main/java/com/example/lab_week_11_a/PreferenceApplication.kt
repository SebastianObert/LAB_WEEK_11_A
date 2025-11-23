package com.example.lab_week_11_a

import android.app.Application
import android.content.Context

class PreferenceApplication : Application() {
    lateinit var preferenceWrapper: PreferenceWrapper

    override fun onCreate() {
        super.onCreate()
        // Inisialisasi preference wrapper
        preferenceWrapper = PreferenceWrapper(
            // Dapat instance SharedPreferences
            // File akan disimpan di /data/data/nama_package/shared_prefs/prefs.xml
            getSharedPreferences("prefs", Context.MODE_PRIVATE)
        )
    }
}