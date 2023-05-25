package com.poblenou.tmb_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class LineaMetroAdapter : RecyclerView.Adapter<LineaMetroAdapter.LineaMetroViewHolder>() {

    class LineaMetroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.linea_metro_imagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineaMetroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_linea_metro, parent, false)
        return LineaMetroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LineaMetroViewHolder, position: Int) {
        holder.imageView.setImageResource(R.drawable.home)
    }

    override fun getItemCount() = 1
}
