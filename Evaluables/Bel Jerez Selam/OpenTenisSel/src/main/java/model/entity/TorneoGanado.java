package model.entity;

import java.util.UUID;

public class TorneoGanado {
    private UUID codTenista;
    private UUID codTorneo;

    public TorneoGanado() {
    }

    public TorneoGanado(UUID codTenista, UUID codTorneo) {
        this.codTenista = codTenista;
        this.codTorneo = codTorneo;
    }

    @Override
    public String toString() {
        return "TorneoGanado{" +
                "codTenista=" + codTenista +
                ", codTorneo=" + codTorneo +
                '}';
    }

    public UUID getCodTenista() {
        return codTenista;
    }

    public void setCodTenista(UUID codTenista) {
        this.codTenista = codTenista;
    }

    public UUID getCodTorneo() {
        return codTorneo;
    }

    public void setCodTorneo(UUID codTorneo) {
        this.codTorneo = codTorneo;
    }
}
