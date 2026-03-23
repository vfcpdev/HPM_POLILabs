package com.edu.android.lesson3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edu.android.R

/**
 * El Adaptador de RecyclerView: Es el puente entre los datos y las vistas (XML).
 */
class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // 1. ViewHolder: Mantiene las referencias a las vistas de una fila ("item_row.xml")
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvRowText: TextView = view.findViewById(R.id.tvRowText)
    }

    // 2. onCreateViewHolder: Se llama cuando el sistema necesita una nueva fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    // 3. onBindViewHolder: Se llama para pintar el contenido de una fila específica
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvRowText.text = items[position]
    }

    // 4. getItemCount: Indica cuántos elementos hay
    override fun getItemCount(): Int = items.size
}
