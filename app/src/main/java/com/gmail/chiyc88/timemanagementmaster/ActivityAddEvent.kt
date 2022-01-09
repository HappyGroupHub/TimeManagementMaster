package com.gmail.chiyc88.timemanagementmaster

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityAddEvent : AppCompatActivity() {
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
    }
}