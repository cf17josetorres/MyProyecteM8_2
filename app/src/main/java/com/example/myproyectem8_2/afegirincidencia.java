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
import android.widget.Toast;

import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class afegirincidencia extends Fragment {

    //Create the instance of dbHelper
    IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    EditText txtIncidencia;
    String valorspinner;
    public Spinner urgencia;

    public afegirincidencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View afegir = inflater.inflate(R.layout.fragment_afegirincidencia, container, false);
        Button btnafegirincidencia = afegir.findViewById(R.id.btnafegirincidencia);

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getActivity(),IncidenciaDBHelper.DATABASE_NAME,null,1);
        //sqLiteDatabase = dbHelper.getWritableDatabase();

        urgencia = afegir.findViewById(R.id.spinner1);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.Lista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        urgencia.setAdapter(adapter);

        urgencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = adapter.getItem(i).toString();
                valorspinner =a;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnafegirincidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtIncidencia = afegir.findViewById(R.id.txtincidencia);
                incidencia inci = new incidencia(txtIncidencia.getText().toString(), valorspinner);
                dbHelper.insertIncidencia(inci);
                dbHelper.close();
                showMessage("insercion correcta");
                /*String urgenci = urgencia.getSelectedItem().toString();
                EditText txtIncidencia = afegir.findViewById(R.id.txtincidencia);
                incidencia inci = new incidencia(txtIncidencia,urgenci);
                dbHelper.insertIncidencia(sqLiteDatabase,inci);*/
            }

            //metodo atajo para el toast vista usuario
            protected void showMessage(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
        return afegir;
    }
}