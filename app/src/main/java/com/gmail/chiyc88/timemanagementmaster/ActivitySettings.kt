package com.gmail.chiyc88.timemanagementmaster

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.*

class ActivitySettings : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {


    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0
    var savedYear = 0
    var savedMonth = 0
    var savedDay = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_settings)
        val ibt_calendar = findViewById<ImageButton>(R.id.ibt_calendar_settings)
        val intent_main = Intent(this, MainActivity::class.java)
        val intent_calendar = Intent(this, ActivityCalendar::class.java)
        val btn_hideFunction = findViewById<Button>(R.id.btn_hideFunction)
        val cb_noticeVoice = findViewById<CheckBox>(R.id.cb_noticeVoice)
        val cb_displayNotice = findViewById<CheckBox>(R.id.cb_displayNotice)
        val l_controlnvisable = findViewById<LinearLayout>(R.id.l_controlnvisable)


        /**是否通知和聲音*/
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        var CB_noticeVoice = "0"
        var CB_displayNotice = "0"
        if (cb_noticeVoice.isChecked) {
            CB_noticeVoice = "1"
        }

        if (cb_displayNotice.isChecked) {
            CB_displayNotice = "1"
        }

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("notice", CB_displayNotice)
        editor.putString("voice", CB_noticeVoice)
        editor.apply()


        /**隱藏按鈕*/
        btn_hideFunction.setOnClickListener {
            if (l_controlnvisable.isVisible) {
                l_controlnvisable.visibility = View.GONE
            } else l_controlnvisable.visibility = View.VISIBLE
        }


        /**通知模擬器*/
        val btn_start = findViewById<Button>(R.id.btn_start)
        btn_start.setOnClickListener {

        }


        ibt_main.setOnClickListener {
            startActivity(intent_main)
        }
        ibt_calendar.setOnClickListener {
            startActivity(intent_calendar)
        }
        pickDateTime()
    }

    /**日期時間選擇*/
    fun getDateTimeCalendar() {
        val cal = Calendar.getInstance()
        year = cal.get(Calendar.YEAR)
        month = cal.get(Calendar.MONTH)
        day = cal.get(Calendar.DAY_OF_MONTH)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    fun pickDateTime() {
        val btn_selectTime2 = findViewById<Button>(R.id.btn_selectTime2)
        btn_selectTime2.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(this, this, year, month, day).show()
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month + 1 //神奇的bug, 要+1才會正常
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute
        var minuteMM = minute.toString()

        /**如果分鐘<10*/
        var hourHH = hourOfDay.toString()
        /**如果小時<10*/
        if (minute < 10) {
            minuteMM = "0$minute"
        }
        if (hourOfDay < 10) {
            hourHH = "0$hourOfDay"
        }

        val tv_time2 = findViewById<TextView>(R.id.tv_time2)
        tv_time2.text = "$savedYear 年$savedMonth 月$savedDay 日\n$minuteMM:$hourHH"
    }


}