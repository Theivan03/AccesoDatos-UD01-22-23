package model.entity;

import java.util.UUID;

public class Torneo {

    private UUID codigo;
    private String nombre;
    private int puntos;
    private double premio;

    public Torneo() {
    }

    public Torneo(UUID codigo, String nombre, int puntos, double premio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntos = puntos;
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                ", premio=" + premio +
                '}';
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }
}
