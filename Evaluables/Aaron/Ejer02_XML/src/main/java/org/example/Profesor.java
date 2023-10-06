package org.example;

import java.time.LocalDate;
import java.util.List;

public class Profesor extends Persona{

    private LocalDate fechaIncorporacion;

    private List<Historial> historial;
    private List<Falta> falta;

    public Profesor(LocalDate fechaIncorporacion, List<Historial> historial, List<Falta> falta) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, double sueldoBruto, LocalDate fechaIncorporacion, List<Historial> historial, List<Falta> falta) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }

    public List<Falta> getFalta() {
        return falta;
    }

    public void setFalta(List<Falta> falta) {
        this.falta = falta;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "fechaIncorporacion=" + fechaIncorporacion +
                ", historial=" + historial +
                ", falta=" + falta +
                '}';
    }
}
