package com.fitness.feature

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.fitness.R

object DialogUtils {

    var dialogExercise: AlertDialog? = null

    fun showExerciseDialog(context: Context?, exerciseListener: exerciseDialogListener?) {
        var dialogBuilder = AlertDialog.Builder(context)
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_exercise, null)

        val btnCloseDialogExersice: ImageView by lazy { dialogView.findViewById<ImageView>(R.id.btnCloseDialogExersice) }
        val tvItemDilogExercise1: TextView by lazy { dialogView.findViewById<TextView>(R.id.tvItemDilogExercise1) }
        val tvItemDilogExercise2: TextView by lazy { dialogView.findViewById<TextView>(R.id.tvItemDilogExercise2) }
        val tvItemDilogExercise3: TextView by lazy { dialogView.findViewById<TextView>(R.id.tvItemDilogExercise3) }
        val btnQuitDialogExercise: Button by lazy { dialogView.findViewById<Button>(R.id.btnQuitDialogExercise) }


        btnCloseDialogExersice.setOnClickListener {
            exerciseListener.let { it?.onDismiss() }
            dialogExercise?.dismiss()
        }

        btnQuitDialogExercise.setOnClickListener {
            exerciseListener.let { it?.onQuit() }
            dialogExercise?.dismiss()
        }
        tvItemDilogExercise1.setOnClickListener {
            tvItemDilogExercise1.isSelected = true
            tvItemDilogExercise2.isSelected = false
            tvItemDilogExercise3.isSelected = false
            exerciseListener.let { it?.onItem1() }
        }
        tvItemDilogExercise2.setOnClickListener {
            tvItemDilogExercise1.isSelected = false
            tvItemDilogExercise2.isSelected = true
            tvItemDilogExercise3.isSelected = false
            exerciseListener.let { it?.onItem2() }
        }
        tvItemDilogExercise3.setOnClickListener {
            tvItemDilogExercise1.isSelected = false
            tvItemDilogExercise2.isSelected = false
            tvItemDilogExercise3.isSelected = true
            exerciseListener.let { it?.onItem3() }
        }

        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        dialogExercise = dialogBuilder.create()
        dialogExercise?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialogExercise?.show()
    }

    interface exerciseDialogListener {
        fun onItem1()
        fun onItem2()
        fun onItem3()
        fun onDismiss()
        fun onQuit()
    }

}