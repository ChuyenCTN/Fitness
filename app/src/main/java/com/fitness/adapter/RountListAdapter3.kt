package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemRoutine3
import com.google.android.material.imageview.ShapeableImageView

class RountListAdapter3() :
    RecyclerView.Adapter<RountListAdapter3.ViewHolder>() {

    var responseList: ArrayList<ItemRoutine3> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_routine_list3, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgItemRoutine3: ShapeableImageView by lazy {
            itemView.findViewById<ShapeableImageView>(
                R.id.imgItemRoutine3
            )
        }
        private val tvTitleItemRoutine3: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTitleItemRoutine3) }

        fun fillData(itemData: ItemRoutine3) {
            itemData?.let { item ->
                tvTitleItemRoutine3.text = if (item.title != null) item.title else ""
                imgItemRoutine3.setImageResource(item.image)
            }
        }
    }

    fun setData(data: ArrayList<ItemRoutine3>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }
}