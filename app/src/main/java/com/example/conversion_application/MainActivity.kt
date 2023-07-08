package com.example.conversion_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conversion_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private enum class ConversionType {
        CM_TO_INCH,
        INCH_TO_CM,
        METER_TO_FEET,
        FEET_TO_METER,
        KG_TO_POUND,
        POUND_TO_KG,
        CELSIUS_TO_FAHRENHEIT,
        FAHRENHEIT_TO_CELSIUS,
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}