package com.example.recyclerViewDemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager


import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.R
import java.util.Collections

class RecyclerViewDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_demo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. Data
        val studentList = mutableListOf(
            Student("Nguyễn Văn A", 20),
            Student("Trần Thị B", 21),
            Student("Lê Văn C", 19),
            Student("Phạm Thị D", 22),
            Student("Đỗ Văn E", 18),
            Student("Nguyễn Thị F", 20),
            Student("Phạm Văn J", 21),
            Student("Trần Quang P", 19),
            Student("Lê Minh K", 22),
            Student("Đỗ Hồng C", 18),
            Student("Hoàng Bích A", 20),
            Student("Vũ Văn G", 21),
            Student("Đặng Thanh Z", 19),
            Student("Lê Thị V", 22),
            Student("Trần Hồng D", 18),
            Student("Nguyễn Minh H", 20),
            Student("Phạm Bích S", 21),
            Student("Đỗ Quang T", 19),
            Student("Lê Thanh M", 22),
            Student("Vũ Ngọc L", 18),
            Student("Hoàng Văn Q", 20),
            Student("Trần Minh R", 21),
            Student("Đặng Thị B", 19),
            Student("Nguyễn Bích X", 22),
            Student("Phạm Ngọc E", 18),
            Student("Lê Thanh N", 20),
            Student("Đỗ Hồng O", 21),
            Student("Hoàng Quang U", 19),
            Student("Vũ Minh I", 22),
            Student("Trần Văn W", 18),
            Student("Đặng Ngọc Y", 20),
            Student("Nguyễn Thị V", 21),
            Student("Phạm Quang S", 19),
            Student("Lê Bích G", 22),
            Student("Đỗ Hồng P", 18)
        )
        //2. Tham chiếu
        var recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        //3. Gán layout cho recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Chuyển đổi layoutManager
        //recyclerView.layoutManager = GridLayoutManager(this,3)
        //recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        //4.Gán adapter cho recyclerView
        var adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter


        //Sự kiện kéo-xóa
        //ItemTouchHelper: kéo thả & vuốt để xóa
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, // Cho phép kéo lên/xuống
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) // Cho phép vuốt trái/phải
        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition

                // Hoán đổi dữ liệu
                Collections.swap(studentList, fromPosition, toPosition)
                // Thông báo adapter
                adapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    studentList.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }
}