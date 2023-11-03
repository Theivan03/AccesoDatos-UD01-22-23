package model.repository.Tenista;

import model.entity.Tenista;

import java.util.List;
import java.util.UUID;

public class TenistaRepository implements ITenistaRepository {
    public TenistaRepository() {
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
    public boolean update(UUID id) {
        return false;
    }

    @Override
    public void save(UUID id) {

    }
}

