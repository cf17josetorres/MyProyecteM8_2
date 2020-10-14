package com.example.myproyectem8_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Menu extends Fragment {

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);
        Button btnAfegir = fMenu.findViewById(R.id.btnAfegir);
        btnAfegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //Log.i("proves", "buttons afegir click");
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                Fragment fAfegirIncidencia = new afegirincidencia();

                menuTransaction.replace(R.id.frameLayout, fAfegirIncidencia);

                menuTransaction.commit();
            }
        });

        Button btnLlistar = fMenu.findViewById(R.id.btnLlistar);
        btnLlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                Fragment fLlistarIncidencia = new afegirincidencia();

                menuTransaction.replace(R.id.frameLayout2, fLlistarIncidencia);

                menuTransaction.commit();
            }
        });

        return fMenu;
    }
}