package com.davidson.compass

abstract class MeasurableSensor(
    protected val senorType: Int
) {

    abstract val doesSensorExist: Boolean

    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract fun startListening()

    abstract fun stopListening()

    fun setOnSensorValuesChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValuesChanged = listener
    }

}