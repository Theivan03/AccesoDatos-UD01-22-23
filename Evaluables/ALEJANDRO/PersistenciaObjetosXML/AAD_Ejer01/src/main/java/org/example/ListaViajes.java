package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@XStreamAlias("viajes")
public class ListaViajes {

    @XStreamImplicit(itemFieldName = "lista")
    private List<Viaje> lista;

    public ListaViajes() {
        this.lista = new ArrayList<>();
    }

    public void add(Viaje viaje) {
        lista.add(viaje);
    }

    public List<Viaje> getLista() {
        return lista;
    }
}
