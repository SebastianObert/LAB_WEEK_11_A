package com.example.lab_week_11_a

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PreferenceWrapper(private val sharedPreferences: SharedPreferences) {

    // LiveData untuk memberi tahu ViewModel jika ada perubahan teks
    private val textLiveData = MutableLiveData<String>()

    init {
        // Daftarkan listener untuk perubahan pada SharedPreferences
        sharedPreferences.registerOnSharedPreferenceChangeListener { _, key ->
            when (key) {
                KEY_TEXT -> {
                    // Beri tahu ViewModel bahwa teks telah berubah
                    textLiveData.postValue(sharedPreferences.getString(KEY_TEXT, ""))
                }
            }
        }
    }

    // Fungsi untuk menyimpan teks ke SharedPreferences
    fun saveText(text: String) {
        sharedPreferences.edit()
            .putString(KEY_TEXT, text)
            .apply()
    }

    // Fungsi untuk mendapatkan teks dari SharedPreferences
    fun getText(): LiveData<String> {
        textLiveData.postValue(sharedPreferences.getString(KEY_TEXT, ""))
        return textLiveData
    }

    // Key yang digunakan untuk menyimpan teks
    companion object {
        const val KEY_TEXT = "keyText"
    }
}