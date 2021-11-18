package com.fitness.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.fitness.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_training -> vpContainer.currentItem = 0
                R.id.nav_routine -> vpContainer.currentItem = 1
                R.id.nav_report -> vpContainer.currentItem = 2
                R.id.nav_setting -> vpContainer.currentItem = 3
            }
            return@setOnNavigationItemSelectedListener true
        }

        vpContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.menu.getItem(position).isChecked = true;
                bottom_navigation.menu.getItem(position);
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        setupViewPager(vpContainer)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TrainingFragment())
        adapter.addFragment(RountineFragment())
        adapter.addFragment(ReportFragment())
        adapter.addFragment(SettingFragment())
        viewPager.adapter = adapter;
        viewPager.offscreenPageLimit = 4
    }
}