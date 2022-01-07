package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ActivityCalendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_calendar)
        val ibt_settings = findViewById<ImageButton>(R.id.ibt_settings_calendar)
        val intent_home = Intent(this, MainActivity::class.java)
        val intent_notify = Intent(this, ActivitySettings::class.java)

        ibt_main.setOnClickListener {
            startActivity(intent_home)
        }
        ibt_settings.setOnClickListener {
            startActivity(intent_notify)
        }
    }
}