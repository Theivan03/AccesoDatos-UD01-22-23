package EJ2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("instituto")
public class Instituto implements Serializable {
    private String nombre;
    @XStreamImplicit(itemFieldName = "persona")
    private List<Persona> personas;

    public Instituto(String nombre, List<Persona> personas) {
        this.nombre = nombre;
        this.personas = personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", personas=" + personas +
                '}';
    }
}
