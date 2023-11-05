package model.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Contrato {
    private UUID codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double sueldo;
    private int codSponsor;

    public Contrato() {
    }

    public Contrato(UUID codigo, LocalDate fechaInicio, LocalDate fechaFin, double sueldo, int codSponsor) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
        this.codSponsor = codSponsor;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "codigo=" + codigo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", sueldo=" + sueldo +
                ", codSponsor=" + codSponsor +
                '}';
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCodSponsor() {
        return codSponsor;
    }

    public void setCodSponsor(int codSponsor) {
        this.codSponsor = codSponsor;
    }
}
