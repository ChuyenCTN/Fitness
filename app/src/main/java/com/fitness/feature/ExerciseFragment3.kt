package com.fitness.feature

import android.os.Build
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_exercise_3.*
import kotlinx.android.synthetic.main.fragment_step_1.*

class ExerciseFragment3(val changePagerListener: ChangePagerListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercise_3, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBackExercise3.setOnClickListener {
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
    }


    fun fakeData() {
        val totalTime = 10000
        var timecurrent = totalTime
        var progress = 0


        Handler().postDelayed(Runnable {
            changePagerListener.onNext()
        }, totalTime.toLong())

    }
}