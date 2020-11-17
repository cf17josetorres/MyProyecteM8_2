package com.example.myproyectem8_2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class afegirincidencia extends Fragment {

    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public Spinner urgencia;

    public afegirincidencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View afegir = inflater.inflate(R.layout.fragment_afegirincidencia, container, false);
        final Button btnafegirincidencia = afegir.findViewById(R.id.btnafegirincidencia);

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();

        /*urgencia = afegir.findViewById(R.id.spinner1);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.Lista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        urgencia.setAdapter(adapter);
        urgencia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String a = adapter.getItem(i).toString();
            }
        });*/

        btnafegirincidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urgenci = urgencia.getSelectedItem().toString();
                EditText txtIncidencia = afegir.findViewById(R.id.txtincidencia);
                //incidencia inci = new incidencia(txtIncidencia,urgenci);
                //dbHelper.insertIncidencia(sqLiteDatabase,inci);


            }
        });
        return afegir;
    }
}