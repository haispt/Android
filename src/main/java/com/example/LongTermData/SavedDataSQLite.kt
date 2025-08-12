package com.example.LongTermData

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

import android.widget.Toast

class SavedDataSQLite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saved_data_sqlite)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tham chiếu biến
        var edtName = findViewById<EditText>(R.id.edtName)
        var edtEmail = findViewById<EditText>(R.id.edtEmail)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnView = findViewById<Button>(R.id.btnView)
        var btnDelete = findViewById<Button>(R.id.btnDelete)
        var tvResult = findViewById<TextView>(R.id.tvResult)


        var dbHelper = DatabaseHelper(this)

        // Xu ly su kien
        btnAdd.setOnClickListener {
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            } else {
                val inserted = dbHelper.insertUser(name, email)
                if (inserted) {
                    Toast.makeText(this, "Đã thêm vào DB", Toast.LENGTH_SHORT).show()
                    edtName.text.clear()
                    edtEmail.text.clear()
                } else {
                    Toast.makeText(this, "Lỗi khi thêm dữ liệu", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // Doc du lieu
        btnView.setOnClickListener {
            val data = dbHelper.getAllUsers()
            tvResult.text = data
        }
        // Xoa du lieu
        btnDelete.setOnClickListener {
            dbHelper.deleteAllUsers()
            tvResult.text = "Dữ liệu đã bị xóa"
        }

    }
}