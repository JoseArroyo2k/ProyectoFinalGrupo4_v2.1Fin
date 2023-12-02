package com.example.proyectofinalgrupo4_v21fin.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalgrupo4_v21fin.Adapter.ordenesAdapter
import com.example.proyectofinalgrupo4_v21fin.R
import com.example.proyectofinalgrupo4_v21fin.model.OrdenesModel
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class OrdenesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_ordenes, container, false)

        val db = FirebaseFirestore.getInstance()
        val lstOrdenes: ArrayList<OrdenesModel> = ArrayList()
        val rvOrdenes: RecyclerView = view.findViewById(R.id.rvOrdenes)

        db.collection("Ordenes")
            .addSnapshotListener { snapshots,e->
                if(e!=null)
                {
                    Log.w("Firebase Warning","error",e)
                    return@addSnapshotListener
                }
                for(dc in snapshots!!.documentChanges){
                    when(dc.type){
                        DocumentChange.Type.ADDED -> {
                            lstOrdenes.add(
                                OrdenesModel(dc.document.data["Repartidor"].toString(),
                                    dc.document.data["Estado"].toString(),
                                    dc.document.data["Restaurante"].toString(),))
                            rvOrdenes.adapter = ordenesAdapter(lstOrdenes)
                        }
                        DocumentChange.Type.MODIFIED -> {
                            lstOrdenes.add(
                                OrdenesModel(dc.document.data["Repartidor"].toString(),
                                    dc.document.data["Estado"].toString(),
                                    dc.document.data["Restaurante"].toString(),))
                            rvOrdenes.adapter = ordenesAdapter(lstOrdenes)

                        }
                        DocumentChange.Type.REMOVED -> {
                            Log.w("Firebase Warning","REMOVED")
                        }
                    }
                }
                rvOrdenes.layoutManager = LinearLayoutManager(requireContext())
            }
        return view
    }
}