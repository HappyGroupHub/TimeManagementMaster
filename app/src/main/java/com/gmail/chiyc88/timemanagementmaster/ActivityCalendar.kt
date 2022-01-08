package com.gmail.chiyc88.timemanagementmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.EventDay

class ActivityCalendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_calendar)
        val ibt_settings = findViewById<ImageButton>(R.id.ibt_settings_calendar)
        val intent_home = Intent(this, MainActivity::class.java)
        val intent_settings = Intent(this, ActivitySettings::class.java)
        val btn_addEvent = findViewById<Button>(R.id.btn_addEvent)

        ibt_main.setOnClickListener {
            startActivity(intent_home)
        }
        ibt_settings.setOnClickListener {
            startActivity(intent_settings)
        }

        btn_addEvent.setOnClickListener {
            val addScheduleFragmeant = AddScheduleFragment()
            val fragmeant : Fragment? =
            supportFragmentManager.findFragmentByTag(AddScheduleFragment::class.java.simpleName)
            if (fragmeant !is AddScheduleFragment) {
                supportFragmentManager.beginTransaction().add(R.id.container, addScheduleFragmeant, AddScheduleFragment::class.java.simpleName).commit()
            }
            btn_addEvent.visibility = View.GONE
        }
    }
}
