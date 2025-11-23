package com.example.lab_week_11_a

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Buat instance DataStore
// File akan disimpan di /data/data/nama_package/files/settingsStore
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settingsStore")

class SettingsStore(private val context: Context) {
    // Flow untuk memberi tahu ViewModel jika ada perubahan teks
    val text: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_TEXT] ?: ""
        }

    // Fungsi untuk menyimpan teks ke DataStore (suspend function)
    suspend fun saveText(text: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_TEXT] = text
        }
    }

    // Key untuk mengakses data
    companion object {
        val KEY_TEXT = stringPreferencesKey("key_text")
    }
}