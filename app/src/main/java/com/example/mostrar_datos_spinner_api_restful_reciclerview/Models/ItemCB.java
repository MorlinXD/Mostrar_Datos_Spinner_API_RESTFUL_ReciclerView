package com.example.mostrar_datos_spinner_api_restful_reciclerview.Models;

import androidx.annotation.NonNull;

public class ItemCB {

    int ID;
    String Descripcion;

    @NonNull
    @Override
    public String toString() {       return Descripcion;    }

    public ItemCB(int ID, String descripcion) {
        this.ID = ID;
        Descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }



}
