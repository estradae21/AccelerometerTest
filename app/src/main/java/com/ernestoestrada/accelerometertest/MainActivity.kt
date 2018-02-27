package com.ernestoestrada.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ernestoestrada.accelerometertest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        accelerometer_data.text = "x = ${event!!.values[0]} \n\n" +
                "y = ${event.values[1]} \n\n" +
                "z = ${event.values[2]}"
        Log.i("x", event!!.values[0].toString())
        Log.i("y", event!!.values[1].toString())
        Log.i("z", event!!.values[2].toString())
        // if (event.values[0] < 0 && event.values[1] < 0) {
        //   Toast.makeText(this, "Level Plane", Toast.LENGTH_SHORT).show()
        //}


    }


    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL)

    }
}