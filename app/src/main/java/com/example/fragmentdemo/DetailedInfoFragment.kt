package com.example.fragmentdemo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailedInfoFragment: Fragment() {
    lateinit var tempTv: TextView
    lateinit var pressureTv: TextView
    lateinit var humidityTv: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_info, container, false)
        tempTv = view.findViewById(R.id.city_temp_value)
        pressureTv = view.findViewById(R.id.pressure_value)
        humidityTv = view.findViewById(R.id.humidity_value)
        val spinner = view.findViewById<Spinner>(R.id.choose_city_spinner)
        val citiesNames = mutableListOf<String>()
        for (city in MainActivity.CITIES) {
            citiesNames.add(city.name)
        }
        val arrayAdapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, citiesNames)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                onItemSelected(p2)
            }
        }
        return view
    }

    fun onItemSelected(position: Int) {
        val currentCity = MainActivity.CITIES[position]
        tempTv.text = "${currentCity.temp} °C"
        pressureTv.text = "${currentCity.pressure} мм рт. ст."
        humidityTv.text = "${currentCity.humidity}%"
    }
}