package com.example.myproyectem8_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproyectem8_2.DB.IncidenciaDBHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class eliminar extends Fragment {

    private ArrayList<incidencia> array;
    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public eliminar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getActivity().getApplicationContext(),IncidenciaDBHelper.DATABASE_NAME, null, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);

        final EditText nombreincidenciaa = view.findViewById(R.id.nombreincidencia);
        final Button elim = view.findViewById(R.id.bt_Eliminar);

        elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titlee = nombreincidenciaa.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("CUIDADO");
                builder.setMessage("VAS A ELIMINAR LA INCIDENCIA, SEGURO QUE LO QUIERES HACER?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dbHelper.incidenciaeliminada(sqLiteDatabase);
                        Toast.makeText(getContext(), "LA INCIDENCIA SE A ELIMINADO", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }
}