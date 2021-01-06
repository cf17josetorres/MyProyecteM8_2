package com.example.myproyectem8_2;

import android.database.Cursor;
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
import android.widget.TextView;

import com.example.myproyectem8_2.DB.IncidenciaContract;
import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class llistaincidencia extends Fragment {

    TextView textoPrueba;
    Button btok;

    public llistaincidencia() {
        // Required empty public constructor
    }

    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_llistaincidencia, container, false);
        //Creation of the dbHelper
        textoPrueba = view.findViewById(R.id.textoPrueba);
        dbHelper = new IncidenciaDBHelper(getActivity().getApplicationContext(),IncidenciaDBHelper.DATABASE_NAME, null, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        consultarDatos();

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
                ArrayList<incidencia> lista = new ArrayList<incidencia>();

                lista = dbHelper.listado();
                int cont =1;
                for(incidencia ina: lista) {
                    System.out.println("insidencia Nª "+cont+" "+ina.getTitol()+" "+ina.getUrgencia()+" "+ina.getData()+" "+ina.getEstat());
                    cont++;
                }
                //dbHelper.close();
            }
        });
        return view;
    }

    private void consultarDatos() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String [] campos = {IncidenciaContract.COLUMN_NAME_TITOL};

        try {
            Cursor cursor = sqLiteDatabase.rawQuery("select title from incidencia",null);
            cursor.moveToFirst();
            textoPrueba.setText(cursor.getString(0));
        } catch (Exception e) {
        }
    }

    public void listarv(View view, int listaestado) {
        //View view = inflater.inflate(R.layout.fragment_llistaincidencia, container, false);
        /*RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RVAdapter adapter = new RVAdapter(getContext(), IncidenciaDBHelper.listado(sqLiteDatabase));
        recyclerView.setAdapter(adapter);*/
    }
}