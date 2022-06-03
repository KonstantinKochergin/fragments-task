package com.example.fragmentdemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentdemo.adapters.CityWeatherAdapter

class ShortInfoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_short_info, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.cities_weather_rv)
        rv.adapter = CityWeatherAdapter(MainActivity.CITIES)
        rv.layoutManager = LinearLayoutManager(view.context)
        return view
    }
}