package com.gmail.chiyc88.timemanagementmaster

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextClock
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

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

        /**讀取活動跟時間*/
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val tv_event = findViewById<TextView>(R.id.tv_event)
        val eventName = preferences.getString("eventName", "")
        val date = preferences.getString("date", "")
        val time = preferences.getString("time", "")

        if (eventName != null) {
            if (!eventName.isEmpty()) {
                tv_event.text = "活動名稱: $eventName\n 時間: $date $time"
            }
        }

        /**現在時間*/
        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        runOnUiThread {
                            val tv_currentTime = findViewById<TextView>(R.id.tv_currentTime)
                            val sdf = SimpleDateFormat("yyyy/M/dd\nHH:mm:ss")
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