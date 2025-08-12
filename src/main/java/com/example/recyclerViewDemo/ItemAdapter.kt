package com.example.recyclerViewDemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class ItemAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.itemText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycle_vew_event, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = itemList[position]
        holder.itemView.setOnClickListener {
            val itemText = itemList[position]
            Toast.makeText(
                holder.itemView.context,
                "Bạn chọn: $itemText (Vị trí: $position)",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int = itemList.size
}