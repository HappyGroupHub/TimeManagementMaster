package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

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
    }
}