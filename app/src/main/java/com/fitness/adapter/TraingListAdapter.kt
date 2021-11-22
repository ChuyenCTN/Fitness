package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemSlideTraining
import com.fitness.model.ItemTraining
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class TraingListAdapter() :
    RecyclerView.Adapter<TraingListAdapter.ViewHolder>() {

    var responseList: ArrayList<ItemTraining> = ArrayList()

    lateinit var itemClick: itemClickListener

    @JvmName("setItemClick1")
    fun setItemClick(itemClickListener: itemClickListener) {
        this.itemClick = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_training, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick.onClick(responseList[position])
        }
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgLeftItemTraining: ImageView by lazy { itemView.findViewById<ImageView>(R.id.imgLeftItemTraining) }
        private val tvDayItemTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvDayItemTraining) }
        private val tvTimeItemTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTimeItemTraining) }
        private val progreesItemTraining: CircularProgressBar by lazy {
            itemView.findViewById<CircularProgressBar>(
                R.id.progreesItemTraining
            )
        }
        private val tvPercentValueItemTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvPercentValueItemTraining) }

        fun fillData(itemData: ItemTraining) {
            itemData?.let { item ->
                tvDayItemTraining.text = if (item.title != null) item.title else ""
                tvTimeItemTraining.text = if (item.time != null) item.time else ""
                tvPercentValueItemTraining.text = "${item.percent}%"
                progreesItemTraining.progress = item.percent.toFloat()
            }
        }
    }

    fun setData(data: ArrayList<ItemTraining>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }

    interface itemClickListener {
        fun onClick(item: ItemTraining)
    }
}