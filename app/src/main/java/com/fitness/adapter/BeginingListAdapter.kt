package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemListBegining
import com.fitness.model.ItemSlideTraining
import com.willy.ratingbar.ScaleRatingBar

class BeginingListAdapter() :
    RecyclerView.Adapter<BeginingListAdapter.ViewHolder>() {

    var responseList: ArrayList<ItemListBegining> = ArrayList()

    lateinit var itemClick: itemClickListener

    @JvmName("setItemClick1")
    fun setItemClick(itemClickListener: itemClickListener) {
        this.itemClick = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_beginer, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(itemClick, responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ratingItemBeginer: ScaleRatingBar by lazy {
            itemView.findViewById<ScaleRatingBar>(
                R.id.ratingItemBeginer
            )
        }
        private val tvTitleItemBegin: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTitleItemBegin) }
        private val tvDayItemBegin: TextView by lazy { itemView.findViewById<TextView>(R.id.tvDayItemBegin) }
        private val imgContentItemBeginer: ImageView by lazy { itemView.findViewById<ImageView>(R.id.imgContentItemBeginer) }

        fun fillData(itemClickListener: itemClickListener, itemData: ItemListBegining) {
            itemData?.let { item ->
                itemView.setOnClickListener {
                    itemClickListener.onClick(item)
                }
                tvTitleItemBegin.text = if (item.title != null) item.title else ""
                tvDayItemBegin.text = if (item.time != null) item.time else ""
                ratingItemBeginer.rating = item.progress.toFloat()
                imgContentItemBeginer.setImageResource(item.image)
            }
        }
    }

    fun setData(data: ArrayList<ItemListBegining>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }


    interface itemClickListener {
        fun onClick(item: ItemListBegining)
    }
}