package com.example.build_your_app.core.utils

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.example.build_your_app.core.utils.AndroidSensor

class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)