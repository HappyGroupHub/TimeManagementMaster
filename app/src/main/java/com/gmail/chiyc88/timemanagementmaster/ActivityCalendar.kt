package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityCalendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val btn_home = findViewById<Button>(R.id.btn_home2)
        val btn_notify = findViewById<Button>(R.id.btn_notify2)
        val intent_home = Intent(this, MainActivity::class.java)
        val intent_notify = Intent(this, ActivityNotify::class.java)

        btn_home.setOnClickListener {
            startActivity(intent_home)
        }
        btn_notify.setOnClickListener {
            startActivity(intent_notify)
        }
    }
}