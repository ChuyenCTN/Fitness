package com.fitness.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemExerciseIndicator
import com.fitness.model.ItemTraining
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class IndicatorExersiseAdapter() :
    RecyclerView.Adapter<IndicatorExersiseAdapter.ViewHolder>() {

    var responseList: ArrayList<ItemExerciseIndicator> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_excerside_indicator, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val indicatorExerciseUnSelect: View by lazy { itemView.findViewById<View>(R.id.indicatorExerciseUnSelect) }
        private val indicatorExerciseSelected: View by lazy { itemView.findViewById<View>(R.id.indicatorExerciseSelected) }

        fun fillData(itemData: ItemExerciseIndicator) {
            itemData.let { item ->
                indicatorExerciseUnSelect.visibility = View.VISIBLE
                if (item.isSelect)
                    indicatorExerciseSelected.visibility = View.VISIBLE
                else indicatorExerciseSelected.visibility = View.GONE
            }
        }
    }

    fun setData(data: ArrayList<ItemExerciseIndicator>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }

    fun setItemSelect(position: Int) {
        Log.d("zxcvbnm,", "${position}")
        Log.d("zxcvbnm,", "${itemCount}")
        responseList[position].isSelect = true
        notifyDataSetChanged()

    }
}