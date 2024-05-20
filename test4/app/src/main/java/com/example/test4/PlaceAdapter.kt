package com.example.test4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(private val places: List<Place>, private val onItemClick: (Place) -> Unit) :
    RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
        holder.itemView.setOnClickListener { onItemClick(place) }
    }

    override fun getItemCount(): Int {
        return places.size
    }

    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(place: Place) {
            textViewName.text = place.name
        }
    }
}