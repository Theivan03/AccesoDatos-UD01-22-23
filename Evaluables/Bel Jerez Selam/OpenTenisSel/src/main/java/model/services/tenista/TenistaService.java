package model.services.tenista;

import model.entity.Tenista;
import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class TenistaService implements ITenistaService {

    private ITenistaRepository iTenistaRepository;

    public TenistaService() {
        iTenistaRepository = new TenistaRepository();
    }

    @Override
    public void save(Tenista tenista) {
        iTenistaRepository.save(tenista);
    }

    @Override
    public Tenista findById(UUID codigo) {
        return iTenistaRepository.findById(codigo);
    }

    @Override
    public List<Tenista> findAll() {
        return iTenistaRepository.findAll();
    }

    @Override
    public boolean delete(UUID codigo) {
        return iTenistaRepository.delete(codigo);
    }

    @Override
    public boolean update(Tenista tenista) {
        return iTenistaRepository.update(tenista);
    }

    @Override
    public boolean addTorneoGanado(String codTenista, String codTorneo) {
        return iTenistaRepository.addTorneoGanado(codTenista, codTorneo);
    }

    @Override
    public boolean addContrato(int codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo) {
        return iTenistaRepository.addContrato(codSponsor,codTenista,fechaInicio,fechaFin,saldo);
    }

    public int getPointsByTenista(String codTenista){
        return iTenistaRepository.getPointsByTenista(codTenista);
    }

    @Override
    public TreeMap<String, List<String>> getTenistaWithSponsor() {
        return iTenistaRepository.getTenistaWithSponsor();
    }
}
