package com.fitness.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitness.R
import com.fitness.adapter.BeginingListAdapter
import com.fitness.adapter.TraingListAdapter
import com.fitness.model.ItemListBegining
import com.fitness.model.ItemTraining
import kotlinx.android.synthetic.main.activity_begin.*
import kotlinx.android.synthetic.main.fragment_training.*
import kotlinx.android.synthetic.main.fragment_training.rcvTraining

class BeginActivity : AppCompatActivity() {

    var adapter: BeginingListAdapter = BeginingListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)

        setUpRCV()
        fakeData()

    }

    fun setUpRCV() {
        if (rcvBegin != null) {
            if (adapter == null)
                adapter = BeginingListAdapter()
            val layoutManager = LinearLayoutManager(this)
            rcvBegin.layoutManager = layoutManager
            rcvBegin.adapter = adapter
        }
    }

    fun fakeData() {
        var responseList: ArrayList<ItemListBegining> = ArrayList()
        for (i in 1..10) {
            responseList.add(ItemListBegining("Day ${i}", "0${i}:1${i}",R.drawable.image_item_beginer,2))
        }
        adapter.setData(responseList)
    }
}