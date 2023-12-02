package com.example.proyectofinalgrupo4_v21fin.Adapter;

import androidx.annotation.NonNull;

public class Productos {
    private int id;
    private String nombre;
    private String precio;

    public Productos(int id, String nombre, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Productos(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
