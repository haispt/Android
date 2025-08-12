package com.example.recyclerViewDemo

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import android.widget.Toast


import android.widget.TextView

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Demo ListView
        // 1. Tham chiếu biến trong layout
        val myListView: ListView = findViewById(R.id.listView)
        val myTextView: TextView = findViewById(R.id.txtListViewSelected)

        // 2. Chuẩn bị dữ liệu để hiển thị
        val dataList = arrayOf(
            "Táo", "Bưởi", "Cam", "Chanh", "Quất",
            "Đào", "Nho", "Bơ", "Xoài", "Mận","Mơ",
            "Mít","Sầu", "Na","Vải","Nhãn", "Hồng",
            "Quýt","Dưa hấu", "Dưa lê", "Dưa gang", "Dưa bở", "Dưa chuột"
        )

        // 3. Tạo ArrayAdapter để kết nối dữ liệu với ListView
        // Layout mặc định cho mỗi item, nếu muốn có thể tự thiết kế riêng
        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, dataList)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, dataList)

        // 4. Gán Adapter cho ListView
        myListView.adapter = adapter

        // 5. Xử lý sự kiện khi một mục trong ListView được nhấp
        myListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // parent: AdapterView mà item này thuộc về
            // view: View được nhấp (ví dụ: TextView của item)
            // position: Vị trí của item trong adapter (0-indexed)
            // id: ID hàng của item được nhấp

            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Bạn đã chọn: $selectedItem (Vị trí: $position)",Toast.LENGTH_SHORT
            ).show()
            myTextView.text = "Bạn đã chọn: $selectedItem (Vị trí: $position)"
        }

    }
}