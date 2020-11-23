package com.example.myproyectem8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button agregar,mostrar,eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        agregar = findViewById(R.id.agregar);
        mostrar = findViewById(R.id.mostrar);
        eliminar = findViewById(R.id.eliminar);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment me = new afegirincidencia();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,me);
                transactiontres.commit();

            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment me = new llistaincidencia();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,me);
                transactiontres.commit();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment me = new eliminar();
                FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
                transactiontres.replace(R.id.contenedor,me);
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