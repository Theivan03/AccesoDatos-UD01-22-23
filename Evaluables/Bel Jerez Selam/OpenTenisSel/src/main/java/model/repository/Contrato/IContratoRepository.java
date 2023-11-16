package model.repository.Contrato;

import model.entity.Contrato;

import java.time.LocalDate;
import java.util.UUID;

public interface IContratoRepository {

    void save(Contrato contrato);
}
