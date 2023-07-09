package com.example.conversion_application

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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
    private var selectedConversionType: ConversionType = ConversionType.CM_TO_INCH

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
                when (position) {
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
        binding.buttonConvert.setOnClickListener {
            convert()
        }
    }
    private fun convert() {
        val input = binding.editTextInput.text.toString().toDoubleOrNull()
        if (input != null) {

            val result = when (selectedConversionType) {
                ConversionType.CM_TO_INCH -> input * 0.393701
                ConversionType.INCH_TO_CM -> input * 2.54
                ConversionType.METER_TO_FEET -> input * 3.28084
                ConversionType.FEET_TO_METER -> input * 0.3048
                ConversionType.KG_TO_POUND -> input * 2.20462
                ConversionType.POUND_TO_KG -> input * 0.453592
                ConversionType.CELSIUS_TO_FAHRENHEIT -> (input * 9 / 5) + 32
                ConversionType.FAHRENHEIT_TO_CELSIUS -> (input - 32) * 5 / 9
            }
            binding.textViewResult.text = result.toString()
        } else {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }
}