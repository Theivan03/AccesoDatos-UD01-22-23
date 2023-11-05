package model.entity;

import java.util.UUID;

public class TenistaContrato {
    private UUID codTenista;
    private UUID codContrato;

    public TenistaContrato() {
    }

    public TenistaContrato(UUID codTenista, UUID codContrato) {
        this.codTenista = codTenista;
        this.codContrato = codContrato;
    }

    @Override
    public String toString() {
        return "TenistaContrato{" +
                "codTenista=" + codTenista +
                ", codContrato=" + codContrato +
                '}';
    }

    public UUID getCodTenista() {
        return codTenista;
    }

    public void setCodTenista(UUID codTenista) {
        this.codTenista = codTenista;
    }

    public UUID getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(UUID codContrato) {
        this.codContrato = codContrato;
    }
}
