package com.fitness.feature

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitness.R
import com.fitness.adapter.CalendarReportAdapter
import com.fitness.adapter.RountListAdapter1
import com.fitness.model.ItemCalendarReport
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.android.synthetic.main.fragment_rountine.*
import kotlinx.android.synthetic.main.fragment_step_1.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ReportFragment : Fragment() {

    var calendarAdapter = CalendarReportAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (calendarAdapter == null)
            calendarAdapter = CalendarReportAdapter()
        val layoutManager = SpanningLinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcvCalendarReport.layoutManager = layoutManager
        rcvCalendarReport.adapter = calendarAdapter

        initListCalendar()

    }

    fun initListCalendar() {
        val SDF2 = SimpleDateFormat("dd/MM/yyyy")
        val SDF1 = SimpleDateFormat("E dd/MM/yyyy")
        val SDF = SimpleDateFormat("yyyy-MM-dd")
        val DAYFORMAT = SimpleDateFormat("dd")
        val EFORMAT = SimpleDateFormat("E")
        val CURRENTDATE2: String =
            SDF2.format(Calendar.getInstance().time)
        val ItemCalendarReports: MutableList<ItemCalendarReport> = ArrayList<ItemCalendarReport>()
        val days: Array<String> = DateCommons.getDaysCurrentWeek(SDF1)
        try {
            for (i in days.indices) {
                ItemCalendarReports.add(
                    ItemCalendarReport(
                        days[i], SDF2.format(SDF1.parse(days[i])), SDF.format(
                            SDF1.parse(
                                days[i]
                            )
                        ), DAYFORMAT.format(SDF1.parse(days[i])), EFORMAT.format(
                            SDF1.parse(
                                days[i]
                            )
                        ).replace("Th ", "T")
                    )
                )
                if (ItemCalendarReports[i].time2.equals(CURRENTDATE2)) {
                    ItemCalendarReports[i].isSelect = true
                }
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        calendarAdapter.setData(ItemCalendarReports as ArrayList<ItemCalendarReport>)

        calendarAdapter.setItemClick(object :CalendarReportAdapter.itemClickListener{
            override fun onClick(itemData: ItemCalendarReport) {

            }
        })
    }
}