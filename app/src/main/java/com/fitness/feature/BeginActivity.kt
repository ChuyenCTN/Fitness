package com.fitness.feature

import android.content.Intent
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
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_begin.*
import kotlinx.android.synthetic.main.bottom_sheet_beginer_detail.*
import kotlinx.android.synthetic.main.fragment_training.*
import kotlinx.android.synthetic.main.fragment_training.rcvTraining
import android.util.DisplayMetrics

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
        initBottomSheet()

        btnStartBegin.setOnClickListener {
            startActivity(Intent(this, ExerciseStartActivity::class.java))
        }

        btnBackBegin.setOnClickListener {
            onBackPressed()
        }

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
            responseList.add(
                ItemListBegining(
                    "Day ${i}",
                    "0${i}:1${i}",
                    R.drawable.image_item_beginer,
                    2
                )
            )
        }
        adapter.setData(responseList)
    }


    private fun initBottomSheet() {
        var sheetBehavior = BottomSheetBehavior.from(layoutBottomSheetDetailBegin)
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        sheetBehavior.peekHeight = 0


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        sheetBehavior.maxHeight = height * 80 / 100

        adapter.setItemClick(object : BeginingListAdapter.itemClickListener {
            override fun onClick(item: ItemListBegining) {
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        })
    }
}