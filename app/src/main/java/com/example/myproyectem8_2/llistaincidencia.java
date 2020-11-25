package com.example.myproyectem8_2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class llistaincidencia extends Fragment {

    public llistaincidencia() {
        // Required empty public constructor
    }

    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();


        /*ArrayList<incidencia> lista = new ArrayList<incidencia>();

        lista = dbHelper.listado();

        for(incidencia ina: lista) {
            System.out.println(ina.getTitol()+" "+ina.getUrgencia());
        }*/

        // Inflate the layout for this fragment
        View llistaincidencia = inflater.inflate(R.layout.fragment_llistaincidencia, container, false);
        RecyclerView recyclerView = (RecyclerView)llistaincidencia.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(llistaincidencia.getContext()));
        RVAdapter adapter = new RVAdapter(this, dbHelper.listado());
        recyclerView.setAdapter(adapter);

        return llistaincidencia;
    }
}