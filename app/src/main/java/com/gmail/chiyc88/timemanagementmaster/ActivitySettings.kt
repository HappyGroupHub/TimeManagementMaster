package com.gmail.chiyc88.timemanagementmaster

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton

class ActivitySettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_settings)
        val ibt_calendar = findViewById<ImageButton>(R.id.ibt_calendar_settings)
        val intent_main = Intent(this, MainActivity::class.java)
        val intent_calendar = Intent(this, ActivityCalendar::class.java)
        val btn_hideFunction =findViewById<Button>(R.id.btn_hideFunction)
        val cb_noticeVoice=findViewById<CheckBox>(R.id.cb_noticeVoice)
        val cb_displayNotice=findViewById<CheckBox>(R.id.cb_displayNotice)

        /**是否通知和聲音*/
        btn_hideFunction.setOnClickListener {
            sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
            var CB_noticeVoice="0"
            var CB_displayNotice="0"
            if(cb_noticeVoice.isChecked){
                CB_noticeVoice="1"
            }

            if(cb_displayNotice.isChecked){
                CB_displayNotice="1"
            }

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("notice",CB_displayNotice)
            editor.putString("voice",CB_noticeVoice)
            editor.apply()
        }

        ibt_main.setOnClickListener {
            startActivity(intent_main)
        }
        ibt_calendar.setOnClickListener {
            startActivity(intent_calendar)
        }
    }
}