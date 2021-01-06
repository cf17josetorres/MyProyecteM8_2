
package com.example.myproyectem8_2;

import android.widget.EditText;

import java.text.SimpleDateFormat;

public class incidencia {
    String titol;
    String urgencia;//(Alta, Mitjana, Baixa)
    String desc;
    int estat;//pendent, assignat, realitza// t
    String data;

    public incidencia() {}

    public incidencia(String titol, String urgencia, String desc, String data) {
        this.titol = titol;
        this.urgencia = urgencia;
        this.desc = desc;
        this.data = data;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getEstat() {
        return estat;
    }

    public void setEstat(int estat) {
        this.estat = estat;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    /*
    No Consigo que la fecha este correctamente.
        Date data = Calendar.getInstance().getTime();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String formatodelafechaactual = formatoFecha.format(data);
        return formatodelafechaactual;
     */
}