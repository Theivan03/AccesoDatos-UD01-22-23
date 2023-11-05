package org.example2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Persona implements Serializable {

    private ArrayList<Instituto> historial;
    private Falta falta;


    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaDeNacimiento, double sueldoBruto, ArrayList<Instituto> historial, Falta falta) {
        super(dni, nombre, apellido1, apellido2, fechaDeNacimiento, sueldoBruto);
        this.historial = historial;
        this.falta = falta;
    }

    public Profesor(ArrayList<Instituto> historial, Falta falta) {
        this.historial = historial;
        this.falta = falta;
    }

    public ArrayList<Instituto> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Instituto> historial) {
        this.historial = historial;
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "historial=" + historial +
                ", falta=" + falta +
                '}';
    }
}
