package com.example.myapplication

import android.os.Bundle

import android.widget.Toast
import android.view.View
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CongHaiSo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cong_hai_so)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Cách 2
        val btnSum1 = findViewById<Button>(R.id.btnSum1)
        btnSum1.setOnClickListener {
            //Toast.makeText(this, "Button clicked, the second way!", Toast.LENGTH_LONG).show()
            tinhTong()
        }

    }

    //Cách 1
    fun tinhTongOnClick(v: View){
        Toast.makeText(this,"Bạn vừa click vào nút tính tổng, C1", Toast.LENGTH_LONG).show()

    }

    fun tinhTong(){

    }



}