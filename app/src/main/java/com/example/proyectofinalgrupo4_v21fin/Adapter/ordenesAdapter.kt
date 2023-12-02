package com.example.proyectofinalgrupo4_v21fin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalgrupo4_v21fin.R
import com.example.proyectofinalgrupo4_v21fin.model.OrdenesModel

class ordenesAdapter(private var lstOrdenes: List<OrdenesModel>): RecyclerView.Adapter<ordenesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val txtRepartidorLista: TextView = itemView.findViewById(R.id.txtRepartidorLista)
        val txtHoraLista: TextView = itemView.findViewById(R.id.txthoraLista)
        val txtEstadoLista: TextView = itemView.findViewById(R.id.txtEstadoLista)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_ordenes,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemOrdenes = lstOrdenes[position]
        holder.txtRepartidorLista.text = itemOrdenes.repartidor
        holder.txtHoraLista.text = itemOrdenes.hora
        holder.txtEstadoLista.text = itemOrdenes.estado
    }

    override fun getItemCount(): Int {
        return lstOrdenes.size
    }
}