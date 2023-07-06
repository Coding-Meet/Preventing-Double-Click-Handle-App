package com.coding.meet.preventingdoubleclickhandleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var mLastClickTime : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickBtn = findViewById<Button>(R.id.clickBtn)
        clickBtn.setOnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return@setOnClickListener
            }
            mLastClickTime = SystemClock.elapsedRealtime()
            // here you can any operation perform
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }
}