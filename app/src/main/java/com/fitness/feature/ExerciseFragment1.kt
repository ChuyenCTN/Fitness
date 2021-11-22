package com.fitness.feature

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.fitness.R
import kotlinx.android.synthetic.main.fragment_step_1.*
import android.os.CountDownTimer
import com.fitness.listener.ChangePagerListener
import kotlinx.android.synthetic.main.fragment_exercise_1.*


class ExerciseFragment1(val changePagerListener: ChangePagerListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercise_1, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fakeData()

    }

    fun fakeData() {
        val totalTime = 10000
        var timecurrent = totalTime
        var progress = 0
        object : CountDownTimer(totalTime.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timecurrent = (millisUntilFinished / 1000).toInt()
                progress = ((totalTime - millisUntilFinished) / 100).toInt()
                progressCountDownExercise1.progress = progress.toFloat()
                tvCountDownExcersice1.setText("${timecurrent}")
            }

            override fun onFinish() {
                progressCountDownExercise1.progress = 100f
                tvCountDownExcersice1.setText("0")
                changePagerListener.onNext()
            }
        }.start()
    }
}