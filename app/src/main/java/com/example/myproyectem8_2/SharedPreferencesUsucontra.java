package com.example.myproyectem8_2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUsucontra {
    private Context context;

    public SharedPreferencesUsucontra(Context context) {
        this.context = context;
    }

    public String getUser() {
        SharedPreferences prefs =
                context.getSharedPreferences("Datos del Login", Context.MODE_PRIVATE);
        return prefs.getString("User", "");
    }

    public String getPassword() {
        SharedPreferences prefs =
                context.getSharedPreferences("Datos del Login", Context.MODE_PRIVATE);
        return prefs.getString("Password", "");
    }

    // Una vez que el usuario es validado, el nombre de usuario y la contraseña se escriben en SharedPreferences
    public void guardaruserpasswd(String user, String password){
        //boolean guardaruserpasswd = false;
        SharedPreferences prefs =
                context.getSharedPreferences("Datos del Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("User", user);
        editor.putString("Password", password);
        editor.commit();
    }

    public boolean guardaruserpasswd() {
        SharedPreferences prefs =
                context.getSharedPreferences("Datos del Login", Context.MODE_PRIVATE);
        boolean username = prefs.getString("User", "").isEmpty();
        boolean pass = prefs.getString("Password", "").isEmpty();
        return username || pass;
    }
}
