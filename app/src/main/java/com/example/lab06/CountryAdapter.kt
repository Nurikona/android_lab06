package com.example.lab06

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val context: Context,
    private val countryList: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagView: ImageView = view.findViewById(R.id.imageView_flag)
        val countryNameView: TextView = view.findViewById(R.id.textView_countryName)
        val populationView: TextView = view.findViewById(R.id.textView_population)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryNameView.text = country.countryName

        holder.populationView.text = context.getString(R.string.population_text, country.population)

        val imageId = context.resources.getIdentifier(country.flagName, "drawable", context.packageName)
        if (imageId != 0) {
            holder.flagView.setImageResource(imageId)
        } else {
            holder.flagView.setImageResource(R.drawable.ic_launcher_foreground)
        }

        holder.itemView.setOnClickListener { onItemClick(country) }
    }

    override fun getItemCount(): Int = countryList.size
}
