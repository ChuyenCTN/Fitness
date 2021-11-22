package com.fitness.feature

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.fitness.adapter.IndicatorExersiseAdapter
import com.fitness.adapter.ViewPagerAdapter
import com.fitness.listener.ChangePagerListener
import com.fitness.model.ItemExerciseIndicator
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import kotlinx.android.synthetic.main.activity_exercise_start.*


class ExerciseStartActivity : AppCompatActivity(), ChangePagerListener {

    var adapterIndicator: IndicatorExersiseAdapter = IndicatorExersiseAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(com.fitness.R.layout.activity_exercise_start)

        setupViewPager(vpExercise)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter?.addTab(ExerciseFragment1(this), "")
        adapter?.addTab(ExerciseFragment2(this), "")
        adapter?.addTab(ExerciseFragment3(this), "")
        adapter?.addTab(ExerciseFragment4(), "")

        viewPager.adapter = adapter;
        viewPager.offscreenPageLimit = 4
        var listIndicator = ArrayList<ItemExerciseIndicator>()

        for (i in 0..adapter.count - 1) {
            listIndicator.add(ItemExerciseIndicator(posistion = i, isSelect = false))
        }

        if (rcvIndicatorExercise != null) {
            if (adapterIndicator == null)
                adapterIndicator = IndicatorExersiseAdapter()
            val layoutManager = GridLayoutManager(this, listIndicator.size)
            rcvIndicatorExercise.layoutManager = layoutManager
            rcvIndicatorExercise.addItemDecoration(LayoutMarginDecoration(listIndicator.size, 8))
            rcvIndicatorExercise.adapter = adapterIndicator
        }
        listIndicator[0].isSelect = true
        adapterIndicator.setData(listIndicator)

        viewPager.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
//                if (position==0)
//                adapterIndicator.setItemSelect(0)
                adapterIndicator.setItemSelect(position)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun onNext() {
        vpExercise.setCurrentItem(vpExercise.currentItem + 1)
    }

    override fun onPrevious() {
        vpExercise.setCurrentItem(vpExercise.currentItem - 1)
    }
}