package com.poblenou.tmb_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(private val productos: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreView: TextView = view.findViewById(R.id.producto_nombre)
        val precioView: TextView = view.findViewById(R.id.producto_precio)
        val imageView: ImageView = view.findViewById(R.id.producto_imagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.nombreView.text = productos[position].nombre
        holder.precioView.text = productos[position].precio
        val resources = holder.itemView.context.resources
        val packageName = holder.itemView.context.packageName
        val resourceId = resources.getIdentifier(productos[position].imagen.toString(), "drawable", packageName)
        holder.imageView.setImageResource(resourceId)
    }

    override fun getItemCount() = productos.size

}
