package model.repository.Tenista;

import model.entity.Tenista;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TenistaRepository implements ITenistaRepository {

    @Override
    public void save(Tenista entity) {
    }

    @Override
    public Tenista findById(UUID id) {
        return null;
    }

    @Override
    public List<Tenista> findAll() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(Tenista entity) {
        return false;
    }

    @Override
    public boolean addTorneoGanado(String codTenista, String codTorneo) {
        return false;
    }

    @Override
    public boolean addContrato(String codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFinal, double saldo) {
        return false;
    }
}

