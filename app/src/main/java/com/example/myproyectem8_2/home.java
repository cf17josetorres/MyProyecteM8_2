package com.example.myproyectem8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button agregar,mostrar,eliminar,confi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        agregar = findViewById(R.id.agregar);
        mostrar = findViewById(R.id.mostrar);
        eliminar = findViewById(R.id.eliminar);
        confi = findViewById(R.id.confi);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment agregar = new afegirincidencia();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,agregar);
                transactiontres.commit();

            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment listar = new llistaincidencia();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,listar);
                transactiontres.commit();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment eliminar = new eliminar();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,eliminar);
                transactiontres.commit();
            }
        });

        confi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment configuracion = new Configuracion();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor, configuracion);
                transactiontres.commit();
            }
        });



        /*Fragment me = new Menu();
        FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
        transactiontres.replace(R.id.contenedor,me);
        transactiontres.commit();*/
    }

    public static Context getContext() {
        return getContext();
    }
}