package com.example.build_your_app.core.fragments.battery_meter

import android.content.Intent
import android.os.BatteryManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BatteryMeterViewModel : ViewModel() {


    fun getBatteryLevel(batteryIntent: Intent?) : Float{
        val level = batteryIntent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batteryIntent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        return scale?.let {
            if (level == -1 && scale == -1) 50.0f else ((level?.toFloat()?.div(it.toFloat()))?.times(
                100
            ))
        } ?: 0.0f
    }

    fun displayProgressiveBattery(progressBar: ProgressBar, textView: TextView, batteryLevel: Int) {
        viewModelScope.launch {
            for (i in 0..batteryLevel) {
                progressBar.progress = i
                textView.text = "$i%"
                delay(50)
            }
        }
    }
}