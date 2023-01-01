package com.example.build_your_app.core.utils

abstract class MeasurableSensor(
    protected val sensorType: Int
) {

    var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val sensorExist: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    fun setOnSensorValuesChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValuesChanged = listener
    }
}