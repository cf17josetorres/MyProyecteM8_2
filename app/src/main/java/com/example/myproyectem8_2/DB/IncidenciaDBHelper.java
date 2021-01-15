package com.example.myproyectem8_2.DB;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myproyectem8_2.incidencia;

import java.util.ArrayList;

import static com.example.myproyectem8_2.DB.IncidenciaContract.COLUMN_NAME_TITOL;
import static com.example.myproyectem8_2.DB.IncidenciaContract.COLUMN_NAME_URGENCIA;
import static com.example.myproyectem8_2.DB.IncidenciaContract.TABLE_NAME;

public class IncidenciaDBHelper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + IncidenciaContract.TABLE_NAME
            + "(" + IncidenciaContract.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + IncidenciaContract.COLUMN_NAME_TITOL + " TEXT, "
            + IncidenciaContract.COLUMN_NAME_URGENCIA + " TEXT, "
            + IncidenciaContract.COLUMN_NAME_DESCRIPCION + " TEXT, "
            + IncidenciaContract.COLUMN_NAME_ESTADO + " TEXT, "
            + IncidenciaContract.COLUMN_NAME_DATA + " TEXT);";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + IncidenciaContract.TABLE_NAME;

    public IncidenciaDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static void modificaelestado(SQLiteDatabase sqLiteDatabase, int estad) {
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        Log.d("Haz creado ", "La Database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    public void insertIncidencia(incidencia inci) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            //values.put(IncidenciaContract.IncidenciaEntry.ID,1);
            values.put(IncidenciaContract.COLUMN_NAME_TITOL, inci.getTitol());
            values.put(IncidenciaContract.COLUMN_NAME_URGENCIA, inci.getUrgencia());
            values.put(IncidenciaContract.COLUMN_NAME_DESCRIPCION, inci.getDesc());
            values.put(IncidenciaContract.COLUMN_NAME_ESTADO, inci.getEstat());
            values.put(IncidenciaContract.COLUMN_NAME_DATA, inci.getData());
            sqLiteDatabase.insert(IncidenciaContract.TABLE_NAME, null, values);
        }

    public static ArrayList<incidencia> listado(SQLiteDatabase sqLiteDatabase) {
        //SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        incidencia insi;
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + IncidenciaContract.TABLE_NAME,null);

        ArrayList<incidencia> incidenciaa = new ArrayList<incidencia>();

        if (cursor.moveToFirst()) {
            do{
                insi = new incidencia();
                insi.setTitol(cursor.getString(0));
                insi.setUrgencia(cursor.getString(1));
                insi.setDesc(cursor.getString(2));
                insi.setEstat(cursor.getInt(3));
                insi.setData(cursor.getString(4));
                insi.setData(cursor.getString(5));
                incidenciaa.add(insi);

            }while (cursor.moveToNext());
        }
        //cursor.close();
        return incidenciaa;
    }

    public void incidenciaeliminadauser(String[] idUsuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,IncidenciaContract.ID+"=?",idUsuario);
    }

    /*public void abrir() {
        this.getWritableDatabase();
    }

    public void cerrar() {
        this.close();
    }*/
}
