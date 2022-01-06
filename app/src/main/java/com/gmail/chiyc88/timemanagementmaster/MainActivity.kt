package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_calendar = findViewById<Button>(R.id.btn_calendar)
        val btn_notify = findViewById<Button>(R.id.btn_notify)
        val intent_calendar = Intent(this, ActivityCalendar::class.java)
        val intent_notify = Intent(this, ActivityNotify::class.java)

        btn_calendar.setOnClickListener {
            startActivity(intent_calendar)
        }
        btn_notify.setOnClickListener {
            startActivity(intent_notify)
        }
    }
}
123