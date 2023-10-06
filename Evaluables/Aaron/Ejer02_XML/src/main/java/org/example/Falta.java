package org.example;

import java.time.LocalDate;

public class Falta {
    private LocalDate fecha;
    private String razon;

    public Falta(LocalDate fecha, String razon) {
        this.fecha = fecha;
        this.razon = razon;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @Override
    public String toString() {
        return "Falta{" +
                "fecha=" + fecha +
                ", razon='" + razon + '\'' +
                '}';
    }
}
