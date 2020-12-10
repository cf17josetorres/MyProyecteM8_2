package com.example.myproyectem8_2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_llistaincidencia, container, false);

        String estat [] = {"Pendent", "Assignat", "Realitzat"};

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, estat);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        Button botonok = view.findViewById(R.id.btok);
        botonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String estatt = spinner.getSelectedItem().toString();
                int listaestado = 0;
                if (estatt.equals("Pendent")) {
                    listaestado = 0;
                } else if (estatt.equals("Assignat")) {
                    listaestado = 1;
                } else if (estatt.equals("Realitzat")) {
                    listaestado = 2;
                }
                listarv(view,listaestado);
            }
        });
        return view;
    }

        /*ArrayList<incidencia> lista = new ArrayList<incidencia>();

        lista = dbHelper.listado();

        for(incidencia ina: lista) {
            System.out.println(ina.getTitol()+" "+ina.getUrgencia());
        }*/

    public void listarv(View view, int listaestado) {
        //View view = inflater.inflate(R.layout.fragment_llistaincidencia, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RVAdapter adapter = new RVAdapter(getContext(), IncidenciaDBHelper.listado(sqLiteDatabase));
        recyclerView.setAdapter(adapter);
    }

}