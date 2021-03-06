package com.example.myproyectem8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button LOGIN;
    SharedPreferencesUsucontra sharepreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);

        LOGIN = findViewById(R.id.LOGIN);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        sharepreferences = new SharedPreferencesUsucontra(getApplicationContext());

        if(!new SharedPreferencesUsucontra(this).guardaruserpasswd()) {
            gotomenu();
        }

        LOGIN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Users user = new Users();
                if ((username.getText().toString().trim().equals(user.getUsername())) && (password.getText().toString().trim().equals(user.getPassword()))){
                //if ((username.getText().toString().trim().equals("")) && (password.getText().toString().trim().equals(""))){
                    SharedPreferences prefs =
                            getSharedPreferences("Datos del Login", Context.MODE_PRIVATE);
                    sharepreferences.getUser();
                    sharepreferences.getPassword();
                    guardaruserpasswd(username.getText().toString().trim(), password.getText().toString().trim());
                    gotomenu();
                }
                else{
                    Snackbar.make(v, "Datos introducidos incorrectamente", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    public void gotomenu(){
        Intent intent = new Intent (getApplicationContext(),home.class);
        startActivity(intent);
    }

    private void guardaruserpasswd(String user, String password) {
        new SharedPreferencesUsucontra(this).guardaruserpasswd(user,
                password);
    }
}