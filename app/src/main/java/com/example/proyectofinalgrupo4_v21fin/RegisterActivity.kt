package com.example.proyectofinalgrupo4_v21fin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinalgrupo4_v21fin.model.UsuarioModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtNombre: EditText = findViewById(R.id.txtNombre)
        val txtCorreo: EditText = findViewById(R.id.txtCorreo)
        val txtClave: EditText = findViewById(R.id.txtClaveReg)
        val txtCelular: EditText = findViewById(R.id.txtCelular)
        val btnRegistro2: Button = findViewById(R.id.btnRegistro2)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        val collectionRef = db.collection("Usuarios")  // Asegúrate de cambiar "Usuarios" al nombre correcto de tu colección

        btnRegistro2.setOnClickListener {
            val correo = txtCorreo.text.toString()
            val clave = txtClave.text.toString()
            val nombreCompleto = txtNombre.text.toString()
            val celular = txtCelular.text.toString()

            auth.createUserWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Se registró en Firebase Auth y deberá registrarse en Firestore
                        val user = auth.currentUser
                        val uid = user?.uid

                        // Utilizamos el modelo para representar los datos del usuario
                        val usuarioModel = UsuarioModel(celular = celular, clave = clave, correo = correo, nombre = nombreCompleto, tipo = "usuario")

                        // Agregamos el modelo a Firestore
                        collectionRef.document(uid ?: "").set(usuarioModel)
                            .addOnCompleteListener {
                                // Manejar la operación completa si es necesario
                                Snackbar
                                    .make(
                                        findViewById(android.R.id.content),
                                        "Registro exitoso del usuario",
                                        Snackbar.LENGTH_LONG
                                    ).show()
                            }.addOnFailureListener { error ->
                                // Manejo de error en caso de fallo al agregar datos a Firestore
                                Snackbar
                                    .make(
                                        findViewById(android.R.id.content),
                                        "Error al registrar en Firestore: ${error.message}",
                                        Snackbar.LENGTH_LONG
                                    ).show()
                            }
                    } else {
                        // Manejo de error al registrar en Firebase Auth
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Error al registrar en Firebase Auth: ${task.exception?.message}",
                                Snackbar.LENGTH_LONG
                            ).show()
                    }
                }
        }
    }
}
