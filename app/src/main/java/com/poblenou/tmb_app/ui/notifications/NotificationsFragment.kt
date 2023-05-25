package com.poblenou.tmb_app.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poblenou.tmb_app.Producto
import com.poblenou.tmb_app.R
import com.poblenou.tmb_app.ProductoAdapter


class NotificationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_compras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productos = listOf(
            Producto(R.drawable.t_usual, "", "20€"),
            Producto(R.drawable.t_casual, "", "11€"),
            Producto(R.drawable.t_familiar, "", "10€"),
            Producto(R.drawable.t_grup, "", "80€"),
            Producto(R.drawable.t_dia, "", "10€"),
            Producto(R.drawable.t_jove, "", "40€"),
            Producto(R.drawable.t_mobilitat, "", "5€")
        )
        
        viewManager = LinearLayoutManager(context)
        viewAdapter = ProductoAdapter(productos)

        recyclerView = view.findViewById<RecyclerView>(R.id.compras_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}