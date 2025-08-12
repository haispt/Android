package com.example.myapplication

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EventOnRadioButon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_on_radio_buton)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val textRadioSelect = findViewById<TextView>(R.id.textRadioSelect)

        radioGroup.setOnCheckedChangeListener{group, checkedId ->
            val selectedId = when (checkedId)
            {
                R.id.radioMale -> "Bạn đã chọn giới tính Nam"
                R.id.radioFemale -> "Bạn đã chọn giới tính Nữ"
                R.id.radioOthers -> "Bạn đã chọn giới tính Khác"
                else -> "Bạn chưa chọn giới tính"
            }
            textRadioSelect.text = selectedId
        }




    }

}