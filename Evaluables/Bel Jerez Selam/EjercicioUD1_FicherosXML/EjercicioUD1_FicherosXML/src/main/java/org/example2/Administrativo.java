package org.example2;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrativo extends Persona implements Serializable {
    private int tiempoContrato;

    public Administrativo(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaDeNacimiento, double sueldoBruto, int tiempoContrato) {
        super(dni, nombre, apellido1, apellido2, fechaDeNacimiento, sueldoBruto);
        this.tiempoContrato = tiempoContrato;
    }

    public Administrativo(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public int getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "tiempoContrato=" + tiempoContrato +
                '}';
    }
}
