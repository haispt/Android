package com.example.LongTermData

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

import android.content.Context

class LongTermDataSaved : AppCompatActivity() {

    //1. Khai báo tên file và key
    val PREFS_NAME = "UserData"
    val KEY_NAME = "name"
    val KEY_EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_long_term_data_saved)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //2. Tham chiếu
        var edtName = findViewById<EditText>(R.id.edtName)
        var edtEmail = findViewById<EditText>(R.id.edtEmail)
        var btnSave = findViewById<Button>(R.id.btnSave)
        var btnRead = findViewById<Button>(R.id.btnRead)
        var btnDelete = findViewById<Button>(R.id.btnDelete)
        var tvResult = findViewById<TextView>(R.id.tvResult)

        // 3. Ghi vào file XML (SharedPreferences)
        btnSave.setOnClickListener {
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString(KEY_NAME, name)
            editor.putString(KEY_EMAIL, email)
            editor.apply()
            tvResult.text = "Đã ghi dữ liệu vào file XML"
        }

        // 4. Đọc từ file XML
        btnRead.setOnClickListener {
            val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val name = sharedPref.getString(KEY_NAME, "Chưa nhập tên")
            val email = sharedPref.getString(KEY_EMAIL, "Chưa nhập email")
            tvResult.text = "Tên: $name\nEmail: $email"
        }

        // 5. Xóa dữ liệu trong file XML
        btnDelete.setOnClickListener {
            val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear() // Xóa toàn bộ key-value
            editor.apply()
            tvResult.text = "Dữ liệu đã bị xóa"
        }


    }
}