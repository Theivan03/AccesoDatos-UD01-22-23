package model.repository.Torneo;

import model.entity.Torneo;

import java.util.List;
import java.util.UUID;

public class TorneoRepository implements ITorneoRepository{
    @Override
    public void save(Torneo entity) {
    }

    @Override
    public Torneo findById(UUID id) {
        return null;
    }

    @Override
    public List<Torneo> findAll() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(Torneo entity) {
        return false;
    }
}
