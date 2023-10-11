package org.example;

import java.util.List;

public class Instituto {

    private String nombre;
    List<Persona> persona;

    public Instituto(String nombre, List<Persona> persona) {
        this.nombre = nombre;
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", persona=" + persona +
                '}';
    }
}
