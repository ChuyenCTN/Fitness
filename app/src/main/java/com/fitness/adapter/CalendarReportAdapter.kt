package com.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.model.ItemCalendarReport

class CalendarReportAdapter() :
    RecyclerView.Adapter<CalendarReportAdapter.ViewHolder>() {

    lateinit var itemClick: itemClickListener

    @JvmName("setItemClick1")
    fun setItemClick(itemClickListener: itemClickListener) {
        this.itemClick = itemClickListener
    }

    var responseList: ArrayList<ItemCalendarReport> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_calendar_report, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            setSelect(position)
            itemClick.onClick(responseList[position])
        }
        holder.fillData(responseList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layoutCalendarNormal: LinearLayout by lazy { itemView.findViewById<LinearLayout>(R.id.layoutCalendarNormal) }
        val tvThItemCalendar: TextView by lazy { itemView.findViewById<TextView>(R.id.tvThItemCalendar) }
        val tvDayItemCalendar: TextView by lazy { itemView.findViewById<TextView>(R.id.tvDayItemCalendar) }
        val layoutCalendarSelect: LinearLayout by lazy { itemView.findViewById<LinearLayout>(R.id.layoutCalendarSelect) }
        val tvThItemCalendarSelect: TextView by lazy { itemView.findViewById<TextView>(R.id.tvThItemCalendarSelect) }
        val tvDayItemCalendarSelect: TextView by lazy { itemView.findViewById<TextView>(R.id.tvDayItemCalendarSelect) }

        fun fillData(itemData: ItemCalendarReport) {
            itemData?.let { item ->
                if (item.isSelect) {
                    layoutCalendarNormal.visibility = View.GONE
                    layoutCalendarSelect.visibility = View.VISIBLE
                    tvDayItemCalendarSelect.text = item.day
                    tvThItemCalendarSelect.text = item.th
                } else {
                    layoutCalendarNormal.visibility = View.VISIBLE
                    layoutCalendarSelect.visibility = View.GONE
                    tvDayItemCalendar.text = item.day
                    tvThItemCalendar.text = item.th
                }
            }
        }
    }

    fun setData(data: ArrayList<ItemCalendarReport>) {
        responseList.clear()
        responseList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.responseList.clear()
        notifyDataSetChanged()
    }

    fun setSelect(position: Int) {
        for (i in responseList.indices) {
            responseList.get(i).isSelect = false
        }
        responseList.get(position).isSelect = true
        notifyDataSetChanged()
    }

    interface itemClickListener {
        fun onClick(itemData: ItemCalendarReport)
    }
}