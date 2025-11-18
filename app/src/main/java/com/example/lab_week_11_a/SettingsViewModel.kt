package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    // LiveData untuk memberi tahu View (Activity) jika ada perubahan teks
    private val _textLiveData = MutableLiveData<String>()
    val textLiveData: LiveData<String> = _textLiveData

    init {
        // Luncurkan coroutine untuk mengambil teks dari DataStore
        viewModelScope.launch {
            settingsStore.text.collect { textValue ->
                _textLiveData.value = textValue
            }
        }
    }

    // Fungsi untuk menyimpan teks
    fun saveText(text: String) {
        // Luncurkan coroutine untuk menyimpan teks ke DataStore
        viewModelScope.launch {
            settingsStore.saveText(text)
        }
    }
}