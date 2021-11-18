package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemRoutine1
import com.google.android.material.imageview.ShapeableImageView

class RountListAdapter1() :
    RecyclerView.Adapter<RountListAdapter1.ViewHolder>() {

    var responseList: ArrayList<ItemRoutine1> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_routine_list1, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgItemRoutine1: ShapeableImageView by lazy {
            itemView.findViewById<ShapeableImageView>(
                R.id.imgItemRoutine1
            )
        }
        private val tvTitleItemRoutine1: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTitleItemRoutine1) }
        private val tvTimeItemRoutine1: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTimeItemRoutine1) }

        fun fillData(itemData: ItemRoutine1) {
            itemData?.let { item ->
                tvTitleItemRoutine1.text = if (item.title != null) item.title else ""
                tvTimeItemRoutine1.text = if (item.time != null) item.time else ""
                imgItemRoutine1.setImageResource(item.image)
            }
        }
    }

    fun setData(data: ArrayList<ItemRoutine1>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }
}