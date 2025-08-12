package com.example.myapplication

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MultiEventHandle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multi_event_handle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.btnMultiEvent)

        val txtAnswer = findViewById<TextView>(R.id.txtAnswer)

        // Sự kiện click
        button.setOnClickListener {
            //Toast.makeText(this, "You clicked!", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Xác nhận")
            builder.setMessage("Bạn có muốn tiếp tục?")

            builder.setPositiveButton("Yes") { dialog, which ->
                txtAnswer.text = "Bạn đã chọn: Yes"
            }

            builder.setNegativeButton("No") { dialog, which ->
                txtAnswer.text = "Bạn đã chọn: No"
            }

            builder.setCancelable(true) // có thể bấm ra ngoài để đóng
            builder.show()
        }

        // Sự kiện chạm cảm ứng
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(this, "Touch DOWN", Toast.LENGTH_SHORT).show()
                }
                MotionEvent.ACTION_MOVE -> {
                    // Viec di chuyển sẽ diễn ra rất niều nên hạn chế bật TOAST
                }
                MotionEvent.ACTION_UP -> {
                    Toast.makeText(this, "Touch UP", Toast.LENGTH_SHORT).show()
                }
            }
            false  // Trả về false để vẫn cho phép click hoạt động
        }

    }
}