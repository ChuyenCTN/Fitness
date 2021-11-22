package com.fitness.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.fitness.R
import kotlinx.android.synthetic.main.activity_pause.*
import android.webkit.WebChromeClient

import android.webkit.WebSettings


class PauseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_pause)

        btnBackPause.setOnClickListener {
            onBackPressed()
        }

        tvModePause.setOnClickListener {
            if (imgContentPause.visibility == View.VISIBLE) {
                imgContentPause.visibility = View.GONE
                videoPlayPause.visibility = View.VISIBLE
                setUpWebview()
            } else {
                imgContentPause.visibility = View.VISIBLE
                videoPlayPause.visibility = View.GONE
                videoPlayPause.onPause()
            }
        }


    }

    fun setUpWebview() {
        if (videoPlayPause.visibility == View.VISIBLE) {
            videoPlayPause.getSettings().setJavaScriptEnabled(true)
            videoPlayPause.getSettings().setJavaScriptCanOpenWindowsAutomatically(true)
            videoPlayPause.getSettings().setPluginState(WebSettings.PluginState.ON)
            videoPlayPause.getSettings().setMediaPlaybackRequiresUserGesture(false)
            videoPlayPause.setWebChromeClient(WebChromeClient())
            videoPlayPause.loadUrl("https://www.youtube.com/embed/ZkTgEo3CbR8")
            videoPlayPause.onResume()
        }
    }
}