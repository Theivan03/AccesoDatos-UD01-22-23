package org.example2;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaDeNacimiento;
    private double sueldoBruto;

    public Persona(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaDeNacimiento, double sueldoBruto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sueldoBruto = sueldoBruto;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", sueldoBruto=" + sueldoBruto +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
}
