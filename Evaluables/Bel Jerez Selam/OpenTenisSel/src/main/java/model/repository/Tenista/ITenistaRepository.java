package model.repository.Tenista;

import model.entity.Tenista;
import model.repository.ICrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public interface ITenistaRepository extends ICrudRepository<Tenista, UUID> {
    // Apartado 2
    boolean addTorneoGanado(String codTenista, String codTorneo);
    boolean addContrato(int codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo);

    int getPointsByTenista(String codTenista);
    TreeMap<String, List<String>> getTenistaWithSponsor();

}
