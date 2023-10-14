package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.time.LocalDate;
import java.util.List;
@XStreamAlias("profesor")
public class Profesor extends Persona {
    private LocalDate fechaIncorporacion;
    @XStreamImplicit(itemFieldName = "historial")
    private List<Historial> historial;
    @XStreamImplicit(itemFieldName = "falta")
    private List<Falta> faltas;

    public Profesor() {

    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, double sueldoBruto, LocalDate fechaIncorporacion, List<Historial> historial, List<Falta> faltas) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.faltas = faltas;
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

    @Override
    public String toString() {
        return "Profesor{" +
                "fechaIncorporacion=" + fechaIncorporacion +
                ", historial=" + historial +
                ", faltas=" + faltas +
                '}';
    }
}
