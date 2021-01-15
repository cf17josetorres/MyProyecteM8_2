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
        dbHelper = new IncidenciaDBHelper(getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RVAdapter adapter = new RVAdapter(getContext(), IncidenciaDBHelper.listado(sqLiteDatabase));
        recyclerView.setAdapter(adapter);
        return view;
    }
}