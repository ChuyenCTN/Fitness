package com.fitness.feature

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitness.R
import com.fitness.adapter.RountListAdapter1
import com.fitness.adapter.RountListAdapter2
import com.fitness.adapter.RountListAdapter3
import com.fitness.model.ItemRoutine1
import com.fitness.model.ItemRoutine2
import com.fitness.model.ItemRoutine3
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import kotlinx.android.synthetic.main.fragment_rountine.*

class RountineFragment : Fragment() {

    var adapter: RountListAdapter1 = RountListAdapter1()
    var adapter2: RountListAdapter2 = RountListAdapter2()
    var adapter3: RountListAdapter3 = RountListAdapter3()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rountine, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRCV()
        fakeData()
    }


    fun setUpRCV() {
        if (rcvRoutine1 != null) {
            if (adapter == null)
                adapter = RountListAdapter1()
            val layoutManager = GridLayoutManager(context, 2)
            rcvRoutine1.layoutManager = layoutManager
            rcvRoutine1.addItemDecoration(LayoutMarginDecoration(2, 16))
            rcvRoutine1.adapter = adapter
        }
        if (rcvRoutine2 != null) {
            if (adapter2 == null)
                adapter2 = RountListAdapter2()
            val layoutManager = GridLayoutManager(context, 2)
            rcvRoutine2.layoutManager = layoutManager
            rcvRoutine2.addItemDecoration(LayoutMarginDecoration(2, 16))
            rcvRoutine2.adapter = adapter2
        }
        if (rcvRoutine3 != null) {
            if (adapter3 == null)
                adapter3 = RountListAdapter3()
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcvRoutine3.layoutManager = layoutManager
            rcvRoutine3.addItemDecoration(LayoutMarginDecoration(16))
            rcvRoutine3.adapter = adapter3
        }
    }

    fun fakeData() {
        var responseList: ArrayList<ItemRoutine1> = ArrayList()
        responseList.add(
            ItemRoutine1(
                "Morning warmup",
                "15 min . 8 workouts",
                R.drawable.image_list_routine_1
            )
        )
        responseList.add(
            ItemRoutine1(
                "Sleepy time stretching",
                "15 min   8 workouts",
                R.drawable.image_list_routine_2
            )
        )

        var responseList2: ArrayList<ItemRoutine2> = ArrayList()
        responseList2.add(
            ItemRoutine2(
                "Sexy booty",
                R.drawable.image_list_routine_2_1
            )
        )
        responseList2.add(
            ItemRoutine2(
                "Fat burning",
                R.drawable.image_list_routine_2_2
            )
        )

        var responseList3: ArrayList<ItemRoutine3> = ArrayList()
        responseList3.add(
            ItemRoutine3(
                "No noise",
                R.drawable.image_list_routine_3_1
            )
        )
        responseList3.add(
            ItemRoutine3(
                "Fast workout",
                R.drawable.image_list_routine_3_2
            )
        )
        responseList3.add(
            ItemRoutine3(
                "For Beginner",
                R.drawable.image_list_routine_3_3
            )
        )

        adapter.setData(responseList)
        adapter2.setData(responseList2)
        adapter3.setData(responseList3)
    }
}