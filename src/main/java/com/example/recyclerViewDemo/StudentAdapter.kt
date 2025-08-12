package com.example.recyclerViewDemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

data class Student(val name: String, val age: Int)

class StudentAdapter(private val students: List<Student>) :

    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.txtHoVaTen)
        val tvAge: TextView = view.findViewById(R.id.txtAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycller_view, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.tvName.text = student.name
        holder.tvAge.text = "Tuổi: ${student.age}"
        // Xử lý sự kiện click vào item
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Bạn chọn: $student (Vị trí: $position)", Toast.LENGTH_SHORT).show()
        }

    }
    override fun getItemCount() = students.size
}
