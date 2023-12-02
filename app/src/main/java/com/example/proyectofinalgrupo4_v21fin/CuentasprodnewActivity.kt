package com.example.proyectofinalgrupo4_v21fin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class CuentasprodnewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuentasprodnew)

        val btnBack: Button = findViewById(R.id.btnBackCPN)
        val txtNameProd: EditText = findViewById(R.id.ProdName)
        val txtDescProd: EditText = findViewById(R.id.editTextTextMultiLine)
        val txtPrice: EditText = findViewById(R.id.editTextTextPrice)


        val btnSaveEdit: Button = findViewById(R.id.btnSaveEditProd)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        val collectionRef = db.collection("Productos")

        btnSaveEdit.setOnClickListener {
            val nombre = txtNameProd.text.toString()
            val desc = txtDescProd.text.toString()
            val precio = txtPrice.text.toString()

            db.collection("Productos").addSnapshotListener{snapshots,e->
                if (e!=null){
                    Log.w("Firebase","listen:error",e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges){
                    when (dc.type){
                        DocumentChange.Type.ADDED ->{
                            Log.d("Firebase","Data: "+dc.document.data)
                            
                        }
                        DocumentChange.Type.MODIFIED -> {

                        }
                        DocumentChange.Type.REMOVED -> {

                        }
                    }
                }
            }
        }
    }
}