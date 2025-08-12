package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View


import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sum2Number : AppCompatActivity() {

    lateinit var txtNumber1:EditText
    lateinit var txtNumber2:EditText
    lateinit var btnSum: Button
    lateinit var txtResult : TextView
    //Thuộc tính khai báo modifier là lateinit sẽ được khởi tạo muộn hơn.
    //Nó sẽ được khởi tạo trước khi bất kỳ tình huống nào cố gắng truy cập nó.

    //Sử dụng giao diện và lớp inner
    //Một lớp inner (inner class) là một lớp được khai báo bên trong một lớp khác.
    // Lớp inner là nó có thể truy cập các thành viên của lớp bên ngoài (outer class), bao gồm cả các thành viên private.

    public inner class ClickHandler:View.OnClickListener{
        override fun onClick(p0:View){
            val btn = p0  as Button
            Toast.makeText(this@Sum2Number,"Ban vua click nut tinh tong cách 4!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sum2_number)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Cách 2
        //Ánh xạ giá trị biến trong layout
        txtNumber1 = findViewById<EditText>(R.id.txtNumber1)
        txtNumber2 = findViewById<EditText>(R.id.txtNumber2)
        txtResult = findViewById<TextView>(R.id.txtResult)
        btnSum = findViewById<Button>(R.id.btnSum)
        btnSum.setOnClickListener {
            //Toast.makeText(this, "Button clicked, the second way!", Toast.LENGTH_LONG).show()
            tinhTong()
        }







//        //Cách 3 - Dùng lambda (1 tham số !!!)
//        findViewById<Button>(R.id.btnSum).setOnClickListener{
//            Toast.makeText(this,"Ban vua bam nut tinh tong bằng cách 3",Toast.LENGTH_SHORT).show()
//        }

        //Cách 4: Khai báo 1 lớp inner để xử lý
        //findViewById<Button>(R.id.btnSum).setOnClickListener(ClickHandler())

        //Cách 5: Khai báo lớp riêng
        //findViewById<Button>(R.id.btnSum).setOnClickListener(MyClickListener(this))

    }

    //Cách 1
//    fun tinhTongOnClick(v: View){
//        Toast.makeText(this,"Bạn vừa click vào nút tính tổng, cách 1", Toast.LENGTH_LONG).show()
//    }

    private fun tinhTong() {
        // Lấy dữ liệu từ EditText
        val number1Str = txtNumber1.text.toString()
        val number2Str = txtNumber2.text.toString()

        // Kiểm tra xem người dùng đã nhập đủ số chưa
        if (number1Str.isEmpty() || number2Str.isEmpty()){
            Toast.makeText(this, "Hãy nhập đủ cả 2 số!", Toast.LENGTH_SHORT).show()
            return  // Không tính tổng nếu nhập thiếu 1 hoặc cả 2 số
        }

        // Chuyển đổi chuỗi sang số
        try{
            val number1 = number1Str.toDouble()
            val number2 = number2Str.toDouble()
            val result = number1 + number2
            txtResult.text = result.toString()
        }
        catch(e:NumberFormatException)
        {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_LONG).show()
            txtResult.text = "Aha có lỗi!"
        }
    }
}

//Khai báo lớp riêng
class MyClickListener(val context:Context):View.OnClickListener{
    override fun onClick(v:View?){
        Toast.makeText(context,"Ban vua click nut tinh tong cách 5!", Toast.LENGTH_SHORT).show()
    }
}