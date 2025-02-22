package com.example.kotlinbasics

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityActDateTimeBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ActDateTime : AppCompatActivity() {
    private lateinit var actDateTimeBinding: ActivityActDateTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        actDateTimeBinding = ActivityActDateTimeBinding.inflate(layoutInflater)
        setContentView(actDateTimeBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        actDateTimeBinding.BtnDate.setOnClickListener {
//            val sdf = SimpleDateFormat("dd / MM / yyyy", Locale.getDefault())
//            val dateCmp = sdf.parse("12 / 12 / 2024")
//            val dateMax = sdf.parse("01 / 01 / 2025")
//            println("Edrr" + sdf.parse("12 / 12 / 2012"))
//            val cal = Calendar.getInstance()
//            DatePickerDialog(
//                this,
//                { _, selectedYear, selectedMonth, selectedDay ->
//                    val calSelected = Calendar.getInstance()
//                    calSelected.set(selectedYear, selectedMonth, selectedDay)
//                    println("Edrr" + calSelected.time)
//                    if (dateCmp != null) {
//                        println("EdrrCheck" + dateCmp.before(calSelected.time))
//                    }
//                    actDateTimeBinding.tvDate.text = sdf.format(calSelected.time)
//                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)
//            )
//                .apply {
//                    datePicker.minDate = dateCmp!!.time
//                    datePicker.maxDate = dateMax!!.time
//                    show()
//                }
        }

        actDateTimeBinding.btnTime.setOnClickListener {
//            val cal = Calendar.getInstance()
//            val sdf = SimpleDateFormat("hh mm a", Locale.getDefault())
//            TimePickerDialog(
//                this,
//                { _, selectedHour, selectedMinute ->
//                    if(((selectedHour<9) || (selectedHour > 18)) || ((selectedHour==18)) && (selectedMinute>0)) {
//                        Toast.makeText(this,"You cannot select this time",Toast.LENGTH_SHORT).show()
//                    } else{
//                        cal.set(Calendar.HOUR_OF_DAY, selectedHour)
//                        cal.set(Calendar.MINUTE, selectedMinute)
//                        println("Edrrr" + sdf.format(cal.time))
//                        actDateTimeBinding.tvTime.text = sdf.format(cal.time)
//                    }
//                },
//                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false
//            ).show()
        }

        actDateTimeBinding.BtnDate.setOnClickListener {
            val sdf=SimpleDateFormat("dd / MMM / yyyy", Locale.getDefault())
            val datePickerBuilder= MaterialDatePicker.Builder.datePicker()
            val datePicker =datePickerBuilder.build()
            datePicker.show(supportFragmentManager,null)
            datePicker.addOnPositiveButtonClickListener { selected->
                actDateTimeBinding.tvDate.text=sdf.format(Date(selected))
            }
        }
        actDateTimeBinding.btnTime.setOnClickListener {
            val sdf=SimpleDateFormat("hh:mm a", Locale.getDefault())
            val timePickerBuilder=MaterialTimePicker.Builder()
            val calInstance=Calendar.getInstance()
            timePickerBuilder.setHour(calInstance.get(Calendar.HOUR_OF_DAY))
            timePickerBuilder.setMinute(calInstance.get(Calendar.MINUTE))
            val timePicker=timePickerBuilder.build()
            timePicker.show(supportFragmentManager,null)

            timePicker.addOnPositiveButtonClickListener {
                calInstance.set(Calendar.HOUR_OF_DAY,timePicker.hour)
                calInstance.set(Calendar.MINUTE,timePicker.minute)
                actDateTimeBinding.tvTime.text=sdf.format(calInstance.time)
            }

        }
    }
}
