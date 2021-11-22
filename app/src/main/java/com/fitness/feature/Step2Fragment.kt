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
import com.fitness.listener.ChangeSplashListener
import kotlinx.android.synthetic.main.fragment_step_1.*
import kotlinx.android.synthetic.main.fragment_step_2.*
import java.text.FieldPosition

class Step2Fragment(val changeSplashListener: ChangeSplashListener) : Fragment(),
    View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_2, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnContinueStep2.setOnClickListener(this)
        layoutBeginer.setOnClickListener(this)
        layoutIntermedate.setOnClickListener(this)
        layoutAdvanced.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layoutBeginer -> {
                layoutBeginer.isSelected = true
                layoutIntermedate.isSelected = false
                layoutAdvanced.isSelected = false
            }
            R.id.layoutIntermedate -> {
                layoutBeginer.isSelected = false
                layoutIntermedate.isSelected = true
                layoutAdvanced.isSelected = false
            }
            R.id.layoutAdvanced -> {
                layoutBeginer.isSelected = false
                layoutIntermedate.isSelected = false
                layoutAdvanced.isSelected = true
            }
            R.id.btnContinueStep2 -> {
                changeSplashListener.onNext()
            }
        }
    }
}