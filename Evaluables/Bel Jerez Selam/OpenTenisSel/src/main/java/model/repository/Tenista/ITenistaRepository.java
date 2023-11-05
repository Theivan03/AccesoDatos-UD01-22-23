package model.repository.Tenista;

import model.entity.Tenista;
import model.repository.ICrudRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface ITenistaRepository extends ICrudRepository<Tenista, UUID> {
    boolean addTorneoGanado(String codTenista, String codTorneo);
    boolean addContrato(String codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFinal, double saldo);
}
