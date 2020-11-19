package com.example.myproyectem8_2.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myproyectem8_2.incidencia;

import java.util.ArrayList;

import static com.example.myproyectem8_2.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITOL;
import static com.example.myproyectem8_2.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_URGENCIA;
import static com.example.myproyectem8_2.DB.IncidenciaContract.IncidenciaEntry.TABLE_NAME;

public class IncidenciaDBHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "(" + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_TITOL + " TEXT," + COLUMN_NAME_URGENCIA + " TEXT)";


    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        Log.d("Haz creado ", "La Database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertIncidencia(SQLiteDatabase sqLiteDatabase, incidencia i){
        //Check the bd is open
        if (sqLiteDatabase.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(COLUMN_NAME_TITOL, i.getTitol());
            values.put(COLUMN_NAME_URGENCIA, i.getUrgencia());

            sqLiteDatabase.insert(IncidenciaContract.IncidenciaEntry.TABLE_NAME, null, values);
        }else{
            Log.d("sql","Database is closed");
        }
    }

    public ArrayList<incidencia> listado() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME,null);
        ArrayList<incidencia> incidenciaa = new ArrayList<>();
        //Cursor c = sqLiteDatabase.rawQuery(sqllite, null);
        if(cursor.moveToFirst()){
            do{
                incidenciaa.add(new incidencia(cursor.getString(0),cursor.getString(1)));
                //String titol = cursor.getString(1);
                //String urgencia = cursor.getString(2);
                //incidenciaa.add(new incidencia(titol, urgencia));
            } while (cursor.moveToNext());
        }
        return incidenciaa;
    }

    public void abrir() {
        this.getWritableDatabase();
    }

    public void cerrar() {
        this.close();
    }
}
