package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.time.LocalDate;
import java.util.List;

@XStreamAlias("profesor")
public class Profesor extends Persona{

    private String fechaIncorporacion;

    @XStreamImplicit(itemFieldName="historial")
    private List<Historial> historial;
    @XStreamImplicit(itemFieldName="falta")
    private List<Falta> falta;

    public Profesor(String fechaIncorporacion, List<Historial> historial, List<Falta> falta) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto, String fechaIncorporacion, List<Historial> historial, List<Falta> falta) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.falta = falta;
    }

    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(String fechaIncorporacion) {
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
