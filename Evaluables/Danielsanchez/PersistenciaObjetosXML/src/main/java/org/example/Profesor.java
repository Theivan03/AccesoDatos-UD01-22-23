package org.example;

import java.time.LocalDate;

public class Profesor extends Persona {
   private LocalDate fechaIncorporacion;
   private Historial historial;

    public Profesor(LocalDate fechaIncorporacion, Historial historial) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
    }

    public Profesor() {
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return super.toString() +"\n Fecha de incorporacion: "+ fechaIncorporacion+ "Historial: "+historial;
    }
}
