package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;
@XStreamAlias("instituto")
public class Instituto implements Serializable {
    private String nombre;
    @XStreamImplicit(itemFieldName = "persona")
    private List<Persona> personas;

    public Instituto(String nombre, List<Persona> listaPersonas) {
        this.nombre = nombre;
        this.personas = listaPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getListaPersonas() {
        return personas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.personas = listaPersonas;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", listaPersonas=" + personas +
                '}';
    }
}
