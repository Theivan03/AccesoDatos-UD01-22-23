package org.example;

import java.util.List;

public class Instituto extends Persona {
    private String nombre;
    private List<Profesor> profesor;
    private List<Administrativo> administrativos;

    public Instituto() {
    }

    public Instituto(String nombre, List<Profesor> profesor, List<Administrativo> administrativos) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.administrativos = administrativos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(List<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }

    @Override
    public String toString() {
        return super.toString()+"\n Instituto{" +
                "nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                ", administrativos=" + administrativos +
                '}';
    }
}
