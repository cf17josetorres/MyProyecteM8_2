package com.example.myproyectem8_2;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Informaciondelosdatos extends Fragment {
    String title, urgenci, descrip, fecha;
    int estad;

    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public Informaciondelosdatos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getActivity().getApplicationContext(),IncidenciaDBHelper.DATABASE_NAME, null, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_informaciondelosdatos, container, false);
        title = getArguments().getString("ITEM_TITLE");
        urgenci = getArguments().getString("ITEM_URGENCIA");
        descrip = getArguments().getString("ITEM_DESCRIPCION");
        fecha = getArguments().getString("ITEM_DATA");
        estad = getArguments().getInt("ITEM_ESTADO");
        refreshestado(v,estad);

        Button btestado = v.findViewById(R.id.btestadus);
        btestado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estad == 1) {
                    IncidenciaDBHelper.modificaelestado(sqLiteDatabase,estad);
                    refreshestado(v,estad);

                } else if (estad == 2) {
                    IncidenciaDBHelper.modificaelestado(sqLiteDatabase, estad);
                    refreshestado(v, estad);
                } else if (estad == 3) {
                    IncidenciaDBHelper.modificaelestado(sqLiteDatabase, estad);
                    refreshestado(v, estad);
                }
            }
        });
        Button btestadoelimina = v.findViewById(R.id.bt_Eliminalaincidencia);
        btestadoelimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminainci(sqLiteDatabase);
            }
        });
        return v;
    }

    private void eliminainci(SQLiteDatabase sqLiteDatabase) {
    }

    public void refreshestado(View v, int estad){
        Button btestado = v.findViewById(R.id.btestadus);
        if (this.estad == 0) {
            btestado.setText(getResources().getString(R.string.estat_pendent));
            btestado.setBackgroundColor(Color.RED);
        } else if (this.estad == 1) {
            btestado.setText(getResources().getString(R.string.estat_assignat));
            btestado.setBackgroundColor(Color.YELLOW);
        }  else if (this.estad == 2) {
            btestado.setText(getResources().getString(R.string.estat_realitzat));
            btestado.setBackgroundColor(Color.GREEN);
        }
    }
}