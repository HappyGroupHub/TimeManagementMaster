package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ActivitySettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_settings)
        val ibt_calendar = findViewById<ImageButton>(R.id.ibt_calendar_settings)
        val intent_main = Intent(this, MainActivity::class.java)
        val intent_calendar = Intent(this, ActivityCalendar::class.java)

        ibt_main.setOnClickListener {
            startActivity(intent_main)
        }
        ibt_calendar.setOnClickListener {
            startActivity(intent_calendar)
        }
    }
}