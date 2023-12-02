package com.example.proyectofinalgrupo4_v21fin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class CuentasprodnewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuentasprodnew)

        val btnBack: Button = findViewById(R.id.btnBackCPN)
        val imgProd: ImageView = findViewById(R.id.imageView4)
    }
}