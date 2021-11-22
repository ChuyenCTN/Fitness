package com.fitness.feature

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.fitness.R
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.activity_start.*
import android.view.Window
import android.view.WindowManager
import com.fitness.adapter.ViewPagerAdapter
import com.fitness.listener.ChangeSplashListener


class StartActivity : AppCompatActivity(), ChangeSplashListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_start)

        setupViewPager(vpStart)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter?.addTab(Step1Fragment(this), "")
        adapter?.addTab(Step2Fragment(this), "")
        adapter?.addTab(Step3Fragment(this), "")
        adapter?.addTab(Step4Fragment(this), "")

        viewPager.adapter = adapter;
        viewPager.offscreenPageLimit = 4

        indicatorView.apply {

            setSliderWidth(
                resources.getDimension(R.dimen.dimen21),
                resources.getDimension(R.dimen.dimen21)
            )
            setSliderHeight(resources.getDimension(R.dimen.dimen6))
            setSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setupWithViewPager(viewPager)
        }

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            @SuppressLint("StringFormatMatches")
            override fun onPageSelected(position: Int) {
                tvStepStart.text =
                    resources.getString(R.string.txt_step_format, (position + 1))
                if (position == 0) {
                    btnBackStart.visibility = View.GONE
                } else {
                    btnBackStart.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        btnBackStart.setOnClickListener {
            onPrevious()
        }
    }

    override fun onNext() {
        vpStart.setCurrentItem(vpStart.currentItem + 1)
    }

    override fun onPrevious() {
        vpStart.setCurrentItem(vpStart.currentItem - 1)
    }
}