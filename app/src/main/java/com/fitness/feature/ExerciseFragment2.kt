package com.fitness.feature

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.fitness.R
import com.fitness.listener.ChangePagerListener
import kotlinx.android.synthetic.main.fragment_exercise_1.*
import kotlinx.android.synthetic.main.fragment_exercise_2.*
import kotlinx.android.synthetic.main.fragment_step_1.*
import kotlin.math.min

class ExerciseFragment2(val changePagerListener: ChangePagerListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercise_2, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgBackExercise2.setOnClickListener {
            DialogUtils.showExerciseDialog(
                requireContext(),
                object : DialogUtils.exerciseDialogListener {
                    override fun onItem1() {
                    }

                    override fun onItem2() {

                    }

                    override fun onItem3() {

                    }

                    override fun onDismiss() {

                    }

                    override fun onQuit() {
//                        requireActivity().onBackPressed()
                        requireActivity().finish()
                    }
                })
        }

        btnMovieExercise2.setOnClickListener {
            startActivity(Intent(requireContext(), PauseActivity::class.java))
        }


        btnNextExercise2.setOnClickListener {
            changePagerListener.onNext()
        }

        btnPreviousExercise2.setOnClickListener {
            changePagerListener.onPrevious()
        }

        btnStateExercise2.setOnClickListener {
            startActivity(Intent(requireContext(), PauseActivity::class.java))
        }
//        fakeData()
    }

    fun fakeData() {
        val totalTime = 10000
        var timecurrent = totalTime
        var progress = 0


        Handler().postDelayed(Runnable {
            changePagerListener.onNext()
        }, 5000)

    }

    fun convertTime(second: Int): String {
        var minute = 0
        var subSecond = 0
        if (second < 10)
            return "00:0${second}"
        else if (second < 60)
            return "00:${second}"
        else {
            minute = second / 60
            subSecond = second % minute
            if (minute < 10 && subSecond < 10) {
                return "0${minute}:0${subSecond}"
            } else if (minute < 10 && subSecond < 60)
                return "0${minute}:${subSecond}"
            else if (minute < 60 && subSecond < 10)
                return "${minute}:0${subSecond}"
            else if (minute < 60 && subSecond < 60)
                return "${minute}:${subSecond}"
        }
        return "00:00"
    }
}
