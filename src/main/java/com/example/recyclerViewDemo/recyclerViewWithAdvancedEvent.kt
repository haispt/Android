package com.example.recyclerViewDemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

import java.util.Collections

class recyclerViewWithAdvancedEvent : AppCompatActivity() {

    //1. Data
    val dataList = mutableListOf(
        "Cà phê",
        "Trà sữa",
        "Nước cam",
        "Nước chanh",
        "Sinh tố xoài"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_with_event)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //2. Tham chiếu
        var recyclerView = findViewById<RecyclerView>(R.id.myRecyclerViewEvent)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = ItemAdapter(dataList)
        recyclerView.adapter = adapter

        //Hiệu ứng
        recyclerView.itemAnimator = DefaultItemAnimator()


        // ItemTouchHelper: kéo thả & vuốt để xóa
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
                Collections.swap(dataList, fromPosition, toPosition)
                // Thông báo adapter
                adapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    dataList.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}