package model.repository.Sponsor;

import model.entity.Sponsor;

import java.util.List;

public class SponsorRepository implements ISponsorRepository{
    public SponsorRepository() {
    }

    @Override
    public void save(Sponsor entity) {

    }

    @Override
    public Sponsor findById(Integer id) {
        return null;
    }

    @Override
    public List<Sponsor> findAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(Sponsor entity) {
        return false;
    }

}
