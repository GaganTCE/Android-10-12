package com.example.kotlinbasics

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityActDateTimeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ActDateTime : AppCompatActivity() {
    private lateinit var actDateTimeBinding: ActivityActDateTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        actDateTimeBinding=ActivityActDateTimeBinding.inflate(layoutInflater)
        setContentView(actDateTimeBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        actDateTimeBinding.BtnDate.setOnClickListener {
            val sdf = SimpleDateFormat("dd / MM / yyyy", Locale.getDefault())
            val dateCmp = sdf.parse("12 / 12 / 2012")
            println("Edrr" + sdf.parse("12 / 12 / 2012"))
            val cal = Calendar.getInstance()
            DatePickerDialog(this,
                {_,selectedYear,selectedMonth,selectedDay ->
                    val calSelected = Calendar.getInstance()
                    calSelected.set(selectedYear,selectedMonth,selectedDay)
                    println("Edrr" + calSelected.time)
                    if (dateCmp != null) {
                        println("EdrrCheck" + dateCmp.before(calSelected.time))
                    }
                     actDateTimeBinding.tvDate.text = sdf.format(calSelected.time)
            },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),  cal.get(Calendar.DATE))
                .show()
        }

        actDateTimeBinding.btnTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val sdf = SimpleDateFormat("hh : mm a", Locale.getDefault())
            TimePickerDialog(this,
                {_,selectedHour, selectedMinute ->
                    val calSelected = Calendar.getInstance()
                    calSelected.set(Calendar.HOUR_OF_DAY,selectedHour)
                    calSelected.set(Calendar.MINUTE,selectedMinute)
                    println("Edrrr" + sdf.format(calSelected.time))
                },
                cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),false)
                .show()
        }
    }
}