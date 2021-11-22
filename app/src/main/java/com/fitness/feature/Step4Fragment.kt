package com.fitness.feature

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fitness.R
import com.fitness.listener.ChangeSplashListener
import kotlinx.android.synthetic.main.fragment_step_4.*

class Step4Fragment(val changeSplashListener: ChangeSplashListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnContinueStep4.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
        }

    }
}