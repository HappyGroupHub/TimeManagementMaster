package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextClock
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ibt_calendar = findViewById<ImageButton>(R.id.ibt_calendar_main)
        val ibt_settings = findViewById<ImageButton>(R.id.ibt_settings_main)
        val intent_calendar = Intent(this, ActivityCalendar::class.java)
        val intent_settings = Intent(this, ActivitySettings::class.java)

        ibt_calendar.setOnClickListener {
            startActivity(intent_calendar)
        }
        ibt_settings.setOnClickListener {
            startActivity(intent_settings)
        }


        /**現在時間*/
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        runOnUiThread {
                            val tv_currentTime = findViewById<TextView>(R.id.tv_currentTime)
                            val sdf = SimpleDateFormat("yyyy/M/dd\nhh:mm:ss")
                            val currentDate = sdf.format(Date())
                            tv_currentTime.text = ("現在時間\n$currentDate")
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }
        t.start()
    }
}