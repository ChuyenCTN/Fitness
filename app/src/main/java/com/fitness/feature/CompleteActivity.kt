package com.fitness.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.fitness.R
import com.fitness.model.PostMessage
import kotlinx.android.synthetic.main.activity_complete.*
import org.greenrobot.eventbus.EventBus

class CompleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_complete)

        btnReportComplete.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).putExtra("ScrollTo", 2))
            finish()
        }

        btnHomeComplete.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}