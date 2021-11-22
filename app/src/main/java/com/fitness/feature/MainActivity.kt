package com.fitness.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import com.fitness.R
import com.fitness.adapter.ViewPagerAdapter
import com.fitness.model.PostMessage
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
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

        val intent = intent
        var position = intent.getIntExtra("ScrollTo", 0)
        vpContainer.setCurrentItem(position)

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