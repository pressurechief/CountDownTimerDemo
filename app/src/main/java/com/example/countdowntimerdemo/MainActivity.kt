package com.example.countdowntimerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000
    private var pauseOffset: Long = 0
    private var tvTimer : TextView? = null
    private var btnStart: Button? = null
    private var btnPause: Button? = null
    private var btnStop: Button? = null
    private var toolbarExercise: Nothing? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarExercise)
        tvTimer!!.text = "${(timerDuration/1000).toString()}"
        btnStart!!.setOnClickListener{
            startTimer(pauseOffset)
        }
        btnPause?.setOnClickListener {
            pauseTimer()
        }
        btnStop!!.setOnClickListener {
            resetTimer()
        }
    }
    private fun startTimer(pauseOffsetL: Long) {
        countDownTimer = object : CountDownTimer(timerDuration - pauseOffsetL, 1000){
            override fun onTick(p0: Long) {
                val millisUntilFinished : Long? = null
                pauseOffset = timerDuration - millisUntilFinished!!
                tvTimer?.text =
                    (millisUntilFinished / 1000).toString()
            }
            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Timer is finished", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
    private fun pauseTimer(){
        if (countDownTimer != null){
            countDownTimer!!.cancel()
        }
    }
    private fun resetTimer(){
        if (countDownTimer != null){
            countDownTimer!!.cancel()
            tvTimer?.text = "${(timerDuration/1000).toString()}"
            countDownTimer = null
            pauseOffset = 0
        }
    }
}


