package model.services.sponsor;

import model.entity.Sponsor;

import java.util.List;

public interface ISponsorService {
    public void save (Sponsor sponsor);
    public Sponsor findById(Integer id);
    public List<Sponsor> findAll();
    public boolean delete (Integer id);
    public boolean update (Sponsor sponsor);
    public List<Sponsor> getRichSponsor();
}
