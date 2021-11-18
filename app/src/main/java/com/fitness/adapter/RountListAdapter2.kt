package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemRoutine1
import com.fitness.model.ItemRoutine2
import com.fitness.model.ItemTraining
import com.google.android.material.imageview.ShapeableImageView
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class RountListAdapter2() :
    RecyclerView.Adapter<RountListAdapter2.ViewHolder>() {

    var responseList: ArrayList<ItemRoutine2> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_routine_list2, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgItemRoutine2: ShapeableImageView by lazy {
            itemView.findViewById<ShapeableImageView>(
                R.id.imgItemRoutine2
            )
        }
        private val tvTitleItemRoutine2: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTitleItemRoutine2) }

        fun fillData(itemData: ItemRoutine2) {
            itemData?.let { item ->
                tvTitleItemRoutine2.text = if (item.title != null) item.title else ""
                imgItemRoutine2.setImageResource(item.image)
            }
        }
    }

    fun setData(data: ArrayList<ItemRoutine2>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }
}