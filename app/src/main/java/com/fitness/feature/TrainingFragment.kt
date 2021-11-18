package com.fitness.feature

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitness.R
import com.fitness.adapter.TraingListAdapter
import com.fitness.model.ItemTraining
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment : Fragment() {

    var adapter: TraingListAdapter = TraingListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRCV()
        fakeData()
    }

    fun setUpRCV() {
        if (rcvTraining != null) {
            if (adapter == null)
                adapter = TraingListAdapter()
            val layoutManager = LinearLayoutManager(context)
            rcvTraining.layoutManager = layoutManager
            rcvTraining.adapter = adapter
        }
    }

    fun fakeData() {
        var responseList: ArrayList<ItemTraining> = ArrayList()
        for (i in 1..10) {
            responseList.add(ItemTraining("Day ${i}", "${i + 2} min . ${i} workout", i))
        }
        adapter.setData(responseList)
    }
}