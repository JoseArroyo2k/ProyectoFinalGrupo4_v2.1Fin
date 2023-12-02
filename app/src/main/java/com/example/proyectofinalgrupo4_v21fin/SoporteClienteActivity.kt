package com.example.proyectofinalgrupo4_v21fin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import  android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.core.view.View

class SoporteClienteActivity : AppCompatActivity() {

    var faqs = arrayOf(
        "¿Cómo restablecer mi contraseña?",
        "¿Cómo actualizar mi información de perfil?",
        "¿Cómo realizar un pedido?",
        "¿Cómo rastrear mi pedido?",
        "Ayuda con mis pagos",
        "Ayuda con mis pedidos",
        "Ayuda con mi cuenta",
        "Ayuda con mis beneficios"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soporte_cliente)
        val faqsListView: ListView = findViewById<ListView>(R.id.faqsListView) as ListView

        // Configurar adaptador para la lista de preguntas frecuentes
        val adaptador: Any? = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, faqs)
        faqsListView.adapter = adaptador as ListAdapter?

        faqsListView.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(
                applicationContext,
                "Position: $position",
                Toast.LENGTH_SHORT
            ).show()
        }

        val contactSupportButton = findViewById<Button>(R.id.contactSupportButton)
        contactSupportButton.setOnClickListener {
            showToast("Abrir formulario de contacto con soporte")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}