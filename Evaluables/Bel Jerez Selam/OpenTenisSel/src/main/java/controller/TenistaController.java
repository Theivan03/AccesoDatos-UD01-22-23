package controller;

import model.entity.Tenista;
import model.services.tenista.ITenistaService;
import model.services.tenista.TenistaService;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class TenistaController {
    private ITenistaService iTenistaService;

    public TenistaController() {
        this.iTenistaService = new TenistaService();
    }

    public void save(Tenista tenista) {
        iTenistaService.save(tenista);
    }

    public List<Tenista> findAll() {
        return iTenistaService.findAll();
    }

    public Tenista findById(UUID id) {
        return iTenistaService.findById(id);
    }

    public boolean delete (UUID id){
        return iTenistaService.delete(id);
    }

    public boolean update(Tenista tenista) {
        return iTenistaService.update(tenista);
    }

    public boolean addTorneoGanado(String codTenista, String codTorneo) {
        return iTenistaService.addTorneoGanado(codTenista, codTorneo);
    }

    public boolean addContrato(int codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo) {
        return iTenistaService.addContrato(codSponsor, codTenista, fechaInicio, fechaFin, saldo);
    }

    public int getPointsByTenista(String codTenista) {
        return iTenistaService.getPointsByTenista(codTenista);
    }

    public TreeMap<String, List<String>> getTenistaWithSponsor() {
        return iTenistaService.getTenistaWithSponsor();
    }
}
