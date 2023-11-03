package model.repository.Tenista;

import model.entity.Tenista;
import model.repository.ICrudRepository;

import java.util.UUID;

public interface ITenistaRepository extends ICrudRepository<Tenista, UUID> {
    boolean update(UUID id);
    void save(UUID id);
}
