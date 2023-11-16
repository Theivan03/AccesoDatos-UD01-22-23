package controller;

import model.entity.Sponsor;
import model.services.sponsor.ISponsorService;
import model.services.sponsor.SponsorService;
import java.util.List;


public class SponsorController {

    private ISponsorService iSponsorService;

    public SponsorController(){ this.iSponsorService = new SponsorService();
    }

    public void save(Sponsor sponsor){
        iSponsorService.save(sponsor);
    }

    public List<Sponsor> findAll(){
        return iSponsorService.findAll();
    }

    public Sponsor findById(int id){
        return iSponsorService.findById(id);
    }
    public boolean update(Sponsor sponsor){
        return iSponsorService.update(sponsor);
    }
    public List<Sponsor> getRichSponsor(){
        return iSponsorService.getRichSponsor();
    }
    public boolean delete(int id){
        return iSponsorService.delete(id);
    }
}
