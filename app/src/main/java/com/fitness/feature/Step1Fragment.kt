package com.fitness.feature

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.fitness.R
import com.fitness.listener.ChangeSplashListener
import kotlinx.android.synthetic.main.fragment_step_1.*
import java.text.SimpleDateFormat

class Step1Fragment(val changeSplashListener: ChangeSplashListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_1, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGetStarted.setOnClickListener {
            changeSplashListener.let {
                it.onNext()
            }
        }
    }
}