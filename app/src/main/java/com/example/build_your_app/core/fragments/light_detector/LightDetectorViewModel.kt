package com.example.build_your_app.core.fragments.light_detector

import com.example.build_your_app.core.utils.MeasurableSensor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LightDetectorViewModel : ViewModel() {
    var lightSensor: MeasurableSensor? = null
    private val _isDark = MutableLiveData(false)
    val isDark: LiveData<Boolean> = _isDark

    fun observeLightSensor() {
        lightSensor?.startListening()
        lightSensor?.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            _isDark.value = lux < 60f
        }
    }
}