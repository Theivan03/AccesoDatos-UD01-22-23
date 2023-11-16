package model.services.tenista;


import model.entity.Tenista;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public interface ITenistaService {

    public void save (Tenista tenista);
    public Tenista findById(UUID codigo);
    public List<Tenista> findAll();
    public boolean delete (UUID codigo);
    public boolean update (Tenista tenista);
    boolean addTorneoGanado(String codTenista, String codTorneo);
    boolean addContrato(int codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo);

    int  getPointsByTenista(String codTenista);
    TreeMap<String, List<String>> getTenistaWithSponsor();
}
