package com.example.myproyectem8_2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_informaciondelosdatos, container, false);
        title = getArguments().getString("ITEM_TITLE");
        urgenci = getArguments().getString("ITEM_URGENCIA");
        descrip = getArguments().getString("ITEM_DESCRIPCION");
        fecha = getArguments().getString("ITEM_DATA");
        estad = getArguments().getInt("ITEM_ESTADO");

        return v;
    }
}