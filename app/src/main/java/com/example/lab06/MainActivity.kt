package com.example.lab06

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = getData()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(this, countryList) { country ->
            Toast.makeText(this, "Selected: ${country.countryName}", Toast.LENGTH_LONG).show()
        }
    }

    private fun getData(): List<Country> {
        return listOf(
            Country("Vietnam", "vietnam", 98000000),
            Country("United States", "usa", 320000000),
            Country("Russia", "russia", 142000000)
        )
    }
}
