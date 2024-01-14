package com.example.mostrar_datos_spinner_api_restful_reciclerview.Listerners;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mostrar_datos_spinner_api_restful_reciclerview.Models.ItemCB;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import webservices.Asynchtask;

public class FillCBListener implements Asynchtask {

    Spinner cb;
    String campoID, campoDesc;
    Boolean addAllItem;
    public FillCBListener(Spinner cb, String campoID, String campoDesc, Boolean addAllItem) {
        this.cb = cb;
        this.campoID = campoID;
        this.campoDesc = campoDesc;
        this.addAllItem = addAllItem;
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<ItemCB> datos = new ArrayList<ItemCB>();
        if(addAllItem) datos.add( new ItemCB(0, "Seleccione una opción"));
        JSONArray JSONlista =  new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject lugar=  JSONlista.getJSONObject(i);
            datos.add( new ItemCB(lugar.getInt(campoID),
                    lugar.getString(campoDesc)));
        }

        ArrayAdapter<ItemCB> adaptador =
                new ArrayAdapter<ItemCB>(cb.getContext(),
                        android.R.layout.simple_spinner_item, datos);


        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cb.setAdapter(adaptador);
    }
}
