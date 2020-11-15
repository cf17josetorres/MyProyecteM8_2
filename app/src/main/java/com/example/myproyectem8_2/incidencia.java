package com.example.myproyectem8_2;

public class incidencia {
    String titol;
    String urgencia;//(Alta, Mitjana, Baixa)

    public incidencia() {}

    public incidencia(String titol, String urgencia) {
        this.titol = titol;
        this.urgencia = urgencia;
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
}