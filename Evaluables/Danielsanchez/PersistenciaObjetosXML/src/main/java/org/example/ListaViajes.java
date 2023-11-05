package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("viajes")
public class ListaViajes {
    private List<Viaje> lista;
    public ListaViajes(){
        this.lista= new ArrayList<>();
    }
    public void add(Viaje viaje){
        this.lista.add(viaje);
    }
    public List<Viaje> getLista(){
        return lista;
    }
}
