package com.example.lab_week_11_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dapet settings store dari application
        val settingsStore = (application as SettingsApplication).settingsStore

        // Buat instance ViewModel menggunakan factory
        val settingsViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SettingsViewModel(settingsStore) as T
            }
        })[SettingsViewModel::class.java]

        // Amati perubahan pada LiveData
        settingsViewModel.textLiveData.observe(this) { textValue ->
            // Perbarui TextView saat data berubah
            findViewById<TextView>(R.id.activity_main_text_view).text = textValue
        }

        // Atur OnClickListener untuk button
        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            // Simpan teks dari EditText saat button diklik
            val newText = findViewById<EditText>(R.id.activity_main_edit_text).text.toString()
            settingsViewModel.saveText(newText)
        }
    }
}