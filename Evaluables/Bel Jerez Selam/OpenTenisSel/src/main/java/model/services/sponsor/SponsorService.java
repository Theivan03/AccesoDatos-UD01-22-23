package model.services.sponsor;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;


import java.util.List;

public class SponsorService implements ISponsorService{

    private ISponsorRepository iSponsorRepository;

    public SponsorService() {
        iSponsorRepository = new SponsorRepository();
    }
    @Override
    public void save(Sponsor sponsor) {
    iSponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor findById(Integer id) {
        return iSponsorRepository.findById(id);
    }

    @Override
    public List<Sponsor> findAll() {
        return iSponsorRepository.findAll();
    }

    @Override
    public boolean delete(Integer id) {
        return iSponsorRepository.delete(id);
    }

    @Override
    public boolean update(Sponsor sponsor) {
        return iSponsorRepository.update(sponsor);
    }
    @Override
    public List<Sponsor> getRichSponsor() {
        return iSponsorRepository.getRichSponsor();
    }


}
