package com.example.myapplication.checkBox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class EventForCheckBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_for_check_box)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var checkMusic = findViewById<CheckBox>(R.id.checkMusic)
        var checkTravel = findViewById<CheckBox>(R.id.checkTravel)
        var checkSport = findViewById<CheckBox>(R.id.checkSport)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var textResult = findViewById<TextView>(R.id.textResult)

        checkMusic.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textResult.text = "Bạn đã chọn: Âm nhạc"
            } else {
                textResult.text = "Bạn chưa chọn: Âm nhạc"
            }
        }

        checkTravel.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textResult.text = "Bạn đã chọn: Du lịch"
            } else {
                textResult.text = "Bạn chưa chọn: Du lịch"
            }
        }

        checkSport.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textResult.text = "Bạn đã chọn: Thể thao"
            } else {
                textResult.text = "Bạn chưa chọn: Thể thao"
            }
        }

        btnSubmit.setOnClickListener {
            var result = ""
            if (checkMusic.isChecked) {
                result += "Âm nhạc, "
            }
            if (checkTravel.isChecked) {
                result += "Du lịch, "
            }
            if (checkSport.isChecked) {
                result += "Thể thao"
            }
            if (result != "") {
                textResult.text = "Sở thích của bạn là " + result}
            else {
                    textResult.text = "Bạn chưa chọn sở thích nào"
                }
        }
    }
}