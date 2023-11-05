package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;
@XStreamAlias("Etapa")
public class Etapa implements Serializable {
    private Lugar destino;
    private Hotel hotel;
    private int numNoches;
    private List<String> puntosVisita;

    public Etapa() {
    }
    private static final long serialVersionUID=5488764001798701613L;
    public Etapa(Lugar destino, Hotel hotel, int numNoches, List<String> puntosVisita) {
        this.destino = destino;
        this.hotel = hotel;
        this.numNoches = numNoches;
        this.puntosVisita = puntosVisita;
    }

    public Lugar getDestino() {
        return destino;
    }

    public void setDestino(Lugar destino) {
        this.destino = destino;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getNumNoches() {
        return numNoches;
    }

    public void setNumNoches(int numNoches) {
        this.numNoches = numNoches;
    }

    public List<String> getPuntosVisita() {
        return puntosVisita;
    }

    public void setPuntosVisita(List<String> puntosVisita) {
        this.puntosVisita = puntosVisita;
    }

    @Override
    public String toString() {
        return "Etapa{" +
                "destino=" + destino +
                ", hotel=" + hotel +
                ", numNoches=" + numNoches +
                ", puntosVisita=" + puntosVisita +
                '}';
    }
}
