package com.example.conversion_application

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
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

        val conversionTypes = listOf(
            "CM to Inch",
            "Inch to CM",
            "Meter to Feet",
            "Feet to Meter",
            "Kg to Pound",
            "Pound to Kg",
            "Celsius to Fahrenheit",
            "Fahrenheit to Celsius"
        )
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, conversionTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerConversionType.adapter = adapter

        binding.spinnerConversionType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var selectedConversionType = when (position) {
                    0 -> ConversionType.CM_TO_INCH
                    1 -> ConversionType.INCH_TO_CM
                    2 -> ConversionType.METER_TO_FEET
                    3 -> ConversionType.FEET_TO_METER
                    4 -> ConversionType.KG_TO_POUND
                    5 -> ConversionType.POUND_TO_KG
                    6 -> ConversionType.CELSIUS_TO_FAHRENHEIT
                    7 -> ConversionType.FAHRENHEIT_TO_CELSIUS
                    else -> ConversionType.CM_TO_INCH // Default to CM to Inch
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Does nothing
            }
        }

    }
}