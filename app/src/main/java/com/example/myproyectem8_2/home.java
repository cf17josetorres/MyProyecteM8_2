package com.example.myproyectem8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Fragment me = new Menu();
        FragmentTransaction transactiontres = getSupportFragmentManager().beginTransaction();
        transactiontres.replace(R.id.contenedor,me);
        transactiontres.commit();
    }
    public static Context getContext() {
        return getContext();
    }
}