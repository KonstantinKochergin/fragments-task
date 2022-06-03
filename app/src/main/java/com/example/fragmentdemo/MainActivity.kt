package com.example.fragmentdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentdemo.dto.CityWeather


class MainActivity : AppCompatActivity() {
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    lateinit var fr1: Fragment
    lateinit var fr2: Fragment
    lateinit var toShortInfoFr: Button
    lateinit var toDetailedInfoFr: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        fr2 = ShortInfoFragment()

        val fr = fm.findFragmentById(R.id.container_fragm)
        if (fr == null) {
            fr1 = DetailedInfoFragment()
            fm.beginTransaction().add(R.id.container_fragm, fr2)
                .commit()
        } else
            fr1 = fr

        toShortInfoFr = findViewById(R.id.short_info)
        toDetailedInfoFr = findViewById(R.id.detailed_info)

        toShortInfoFr.setOnClickListener {

            val ft = fm.beginTransaction()
            ft.replace(R.id.container_fragm, fr2)
            ft.commit()
        }

        toDetailedInfoFr.setOnClickListener {
            val ft = fm.beginTransaction()
            ft.replace(R.id.container_fragm, fr1)
            ft.commit()
        }
    }

    companion object {
        val CITIES = arrayOf<CityWeather>(
            CityWeather("Иркутск", 8f, 707.5f, 100),
            CityWeather("Москва", 20f, 750f, 77),
            CityWeather("Красноярск", 13f, 746f, 56),
            CityWeather("Владивосток", 11f, 756.4f, 94),
        )
    }
}
