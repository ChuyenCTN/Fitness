package com.fitness.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.fitness.R
import com.fitness.listener.ChangeSplashListener
import kotlinx.android.synthetic.main.fragment_step_3.*

class Step3Fragment(val changeSplashListener: ChangeSplashListener) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvUnitCm.isSelected = true
        tvMale.isSelected = true

        btnContinueStep3.setOnClickListener {
            changeSplashListener.onNext()
        }

        layoutUnitStep3.setOnClickListener {
            if (tvUnitCm.isSelected) {
                tvUnitCm.isSelected = false
                tvUnitFt.isSelected = true
            } else {
                tvUnitCm.isSelected = true
                tvUnitFt.isSelected = false
            }
        }

        layoutGenderStep3.setOnClickListener {
            if (tvMale.isSelected) {
                tvMale.isSelected = false
                tvFemale.isSelected = true
            } else {
                tvMale.isSelected = true
                tvFemale.isSelected = false
            }
        }

        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                requireContext().hideKeyboard(view)
                false
            }
        }
    }

    fun Context.hideKeyboard(view: View) {
        ContextCompat.getSystemService(this, InputMethodManager::class.java)?.apply {
            hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}