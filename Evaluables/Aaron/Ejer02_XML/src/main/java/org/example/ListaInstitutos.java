package org.example;

import java.util.List;

public class ListaInstitutos {

    private List<Instituto> listaIntitutos;

    public ListaInstitutos(List<Instituto> listaIntitutos) {
        this.listaIntitutos = listaIntitutos;
    }

    public List<Instituto> getListaIntitutos() {
        return listaIntitutos;
    }

    public void setListaIntitutos(List<Instituto> listaIntitutos) {
        this.listaIntitutos = listaIntitutos;
    }

    @Override
    public String toString() {
        return "ListaInstitutos{" +
                "listaIntitutos=" + listaIntitutos +
                '}';
    }
}
