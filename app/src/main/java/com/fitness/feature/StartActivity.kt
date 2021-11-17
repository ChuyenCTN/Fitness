package com.fitness.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.fitness.R
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.activity_start.*
import android.util.TypedValue




class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setupViewPager(vpStart)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter?.addTab(Step1Fragment(), "")
        adapter?.addTab(Step2Fragment(), "")
        adapter?.addTab(Step3Fragment(), "")
        adapter?.addTab(Step4Fragment(), "")

        viewPager.adapter = adapter;
        viewPager.offscreenPageLimit = 4

        val normalWidth = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, resources.getDimension(R.dimen.dimen21),
            getResources().getDisplayMetrics()
        )

        indicatorView.apply {
            setSliderColor(R.color.color_un_selected_dot, R.color.color_selected_dot)
            setSliderWidth(resources.getDimension(R.dimen.dimen21),resources.getDimension(R.dimen.dimen21))
            setSliderHeight(resources.getDimension(R.dimen.dimen6))
            setSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setupWithViewPager(viewPager)
        }
    }
}