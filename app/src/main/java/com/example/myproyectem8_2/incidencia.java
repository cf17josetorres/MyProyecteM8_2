package com.example.myproyectem8_2;

import android.widget.EditText;

import java.text.SimpleDateFormat;

public class incidencia {
    String titol;
    String urgencia;//(Alta, Mitjana, Baixa)
    String desc;
    int estat;//pendent, assignat, realitzat
    long data;

    public incidencia() {}

    public incidencia(String titol, String urgencia) {
        this.titol = titol;
        this.urgencia = urgencia;
    }

    public incidencia(EditText txtIncidencia, String urgenci) {
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

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String fechaactual(){
        Long data = this.getData()*1000;
        String formatodelafechaactual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
        return formatodelafechaactual;
    }
}