package com.gmail.chiyc88.timemanagementmaster

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import java.util.*
import com.applandeo.materialcalendarview.EventDay

class ActivityCalendar : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            //驗證發出對象
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                val calendarView =
                    findViewById<com.applandeo.materialcalendarview.CalendarView>(R.id.calendarView)
                for (calendar in calendarView.selectedDates) {
                    calendar.time = calendar.time
                    val event: MutableList<EventDay> = ArrayList()
                    /**在event陣列中新增一個元素 */
                    event.add(EventDay(calendar, R.drawable.clock))
                    runOnUiThread {
                        /**刷新介面 */
                        calendarView.setEvents(event)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val ibt_main = findViewById<ImageButton>(R.id.ibt_main_calendar)
        val ibt_settings = findViewById<ImageButton>(R.id.ibt_settings_calendar)
        val btn_addEvent = findViewById<Button>(R.id.btn_addEvent)
        val intent_home = Intent(this, MainActivity::class.java)
        val intent_settings = Intent(this, ActivitySettings::class.java)

        ibt_main.setOnClickListener {
            startActivity(intent_home)
        }
        ibt_settings.setOnClickListener {
            startActivity(intent_settings)
        }

        val calendarView =
            findViewById<com.applandeo.materialcalendarview.CalendarView>(R.id.calendarView)

        btn_addEvent.setOnClickListener {
            val intent_addEvent = Intent(this, ActivityAddEvent::class.java)

            /**Initialize Long */
            var selectedDate = 1L
            /**利用forEach迴圈找出指定元素 */
            for (calendar in calendarView.selectedDates) {
                selectedDate = calendar.timeInMillis
            }
            val b = Bundle()
            b.putString("selectedDate", selectedDate.toString())
            intent_addEvent.putExtras(b)
            startActivityForResult(intent_addEvent, 1)
        }
    }
}
