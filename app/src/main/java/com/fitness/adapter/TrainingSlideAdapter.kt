package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemSlideTraining
import com.google.android.material.imageview.ShapeableImageView
import com.willy.ratingbar.ScaleRatingBar

class TrainingSlideAdapter : RecyclerView.Adapter<TrainingSlideAdapter.ViewHolder>() {

    var responseList: ArrayList<ItemSlideTraining> = ArrayList()

    lateinit var itemClick: itemClickListener

    @JvmName("setItemClick1")
    fun setItemClick(itemClickListener: itemClickListener) {
        this.itemClick = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_slide_training, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(itemClick, responseList[position])
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgContentItemSlideTraining: ShapeableImageView by lazy {
            itemView.findViewById<ShapeableImageView>(
                R.id.imgContentBegin
            )
        }
        private val ratingItemSlideTraining: ScaleRatingBar by lazy {
            itemView.findViewById<ScaleRatingBar>(
                R.id.ratingBegin
            )
        }
        private val tvTitleSlideTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTitleBegin) }
        private val tvContentSlideTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvContentBegin) }
        private val tvTimeSlideTraining: TextView by lazy { itemView.findViewById<TextView>(R.id.tvTimeBegin) }

        fun fillData(itemClickListener: itemClickListener, itemData: ItemSlideTraining) {
            itemData.let { data ->
                itemView.setOnClickListener {
                    itemClickListener.onClick(data)
                }
                tvTitleSlideTraining.text = if (data.title1 != null) data.title1 else ""
                imgContentItemSlideTraining.setImageResource(data.image)
                tvContentSlideTraining.text = if (data.title2 != null) data.title2 else ""
                tvTimeSlideTraining.text = if (data.time != null) data.time else ""
                ratingItemSlideTraining.rating = data.progress.toFloat()
            }
        }
    }

    fun setData(data: ArrayList<ItemSlideTraining>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }

    interface itemClickListener {
        fun onClick(item: ItemSlideTraining)
    }
}