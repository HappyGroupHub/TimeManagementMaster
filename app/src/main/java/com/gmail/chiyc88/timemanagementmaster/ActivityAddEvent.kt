package com.gmail.chiyc88.timemanagementmaster

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ActivityAddEvent : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {

    var hour = 0
    var minute = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        val selectedDate = intent.getStringExtra("selectedDate")
        val simpleDateFormat = SimpleDateFormat("yyyy年 MM月 dd日")
        val dateLong = simpleDateFormat.format(selectedDate?.toLong())
        val tv_selectedDate = findViewById<TextView>(R.id.tv_selectedDate)
        tv_selectedDate.text = String.format(dateLong)


        val btn_done = findViewById<Button>(R.id.btn_done)
        btn_done.setOnClickListener {
            val b = Bundle()
            setResult(Activity.RESULT_OK, Intent().putExtras(b))
            finish()
        }
        pickTime()
    }

    fun getTimeCalendar() {
        val cal = Calendar.getInstance()
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    fun pickTime() {
        val btn_selectTime = findViewById<Button>(R.id.btn_selectTime)
        btn_selectTime.setOnClickListener {
            getTimeCalendar()

            TimePickerDialog(this, this, hour, minute, true).show()

        }
    }
    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute
        val tv_time = findViewById<TextView>(R.id.tv_time)
        tv_time.text = "$hourOfDay:$minute"

    }
}