package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PreferenceViewModel(private val preferenceWrapper: PreferenceWrapper) : ViewModel() {

    // Fungsi untuk menyimpan teks
    fun saveText(text: String) {
        preferenceWrapper.saveText(text)
    }

    // Fungsi untuk mendapatkan teks
    fun getText(): LiveData<String> {
        return preferenceWrapper.getText()
    }
}