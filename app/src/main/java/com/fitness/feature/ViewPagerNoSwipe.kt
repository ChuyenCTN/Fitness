package com.fitness.feature

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.viewpager.widget.ViewPager
import android.view.MotionEvent


class ViewPagerNoSwipe(context: Context?, attrs: AttributeSet?) :
    ViewPager(context!!, attrs) {

    var enabledd = false

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (enabledd) super.onTouchEvent(event) else false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (enabledd) super.onInterceptTouchEvent(event) else false
    }

    override fun executeKeyEvent(event: KeyEvent): Boolean {
        return if (enabledd) super.executeKeyEvent(event) else false
    }

    fun setSwipeEnabled(enabled: Boolean) {
        this.enabledd = enabled
    }
}