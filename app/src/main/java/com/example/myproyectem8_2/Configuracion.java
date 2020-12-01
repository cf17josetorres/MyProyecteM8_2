package com.example.myproyectem8_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Configuracion extends Fragment {
    private  static SharedPreferences sharepreferences;

    public Configuracion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuracion, container, false);

        Button btes = view.findViewById(R.id.bt_ES_configuracion);
        Button bten = view.findViewById(R.id.bt_EN_configuracion);
        Button btretur = view.findViewById(R.id.bt_return);

        sharepreferences = getContext().getSharedPreferences("Datos de Configuración de Idioma", Context.MODE_PRIVATE);

        btes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lenguage("es");
            }
        });

        bten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lenguage("en");
            }
        });

        btretur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharepreferences.edit().remove("LENGUAGE").commit();
                sharepreferences.edit().remove("User").commit();
                sharepreferences.edit().remove("Password").commit();
                refresh();
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }

    //https://jarroba.com/foro/1028/boton-para-cambiar-idioma-de-la-aplicacion
    public void lenguage (String locale) {
        Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        sharepreferences.edit().putString("LENGUAGE", locale).commit();
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        refresh();
    }

    public void refresh(){
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        Fragment confii = new Configuracion();
        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTransaction = menuManager.beginTransaction();
        menuTransaction.replace(R.id.Menu, confii).commit();
    }
}