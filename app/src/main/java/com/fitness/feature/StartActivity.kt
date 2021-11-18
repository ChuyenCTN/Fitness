package com.fitness.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.viewpager.widget.ViewPager
import com.fitness.R
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.activity_start.*
import android.view.Window
import android.view.WindowManager


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_start)

        setupViewPager(vpStart)


//        Handler().postDelayed(
//            Runnable {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }, 5000
//        )
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter?.addTab(Step1Fragment(), "")
        adapter?.addTab(Step2Fragment(), "")
        adapter?.addTab(Step3Fragment(), "")
        adapter?.addTab(Step4Fragment(), "")

        viewPager.adapter = adapter;
        viewPager.offscreenPageLimit = 4

        indicatorView.apply {

            setSliderWidth(resources.getDimension(R.dimen.dimen21),resources.getDimension(R.dimen.dimen21))
            setSliderHeight(resources.getDimension(R.dimen.dimen6))
            setSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setupWithViewPager(viewPager)
        }
    }
}