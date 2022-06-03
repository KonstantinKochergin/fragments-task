package com.example.fragmentdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentdemo.R
import com.example.fragmentdemo.dto.CityWeather

class CityWeatherAdapter(private val cities: Array<CityWeather>): RecyclerView.Adapter<CityWeatherAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityNameTv: TextView
        val cityTempTv: TextView

        init {
            cityNameTv = view.findViewById(R.id.city_name)
            cityTempTv = view.findViewById(R.id.city_temp)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_weather_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityNameTv.text = cities[position].name
        holder.cityTempTv.text = "${cities[position].temp} °C"
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}