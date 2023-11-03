package model.services.sponsor;

import model.repository.Sponsor.ISponsorRepository;
import model.repository.Sponsor.SponsorRepository;

public class SponsorService implements ISponsorService{

    private ISponsorRepository iSponsorRepository;

    public SponsorService() {
        iSponsorRepository = new SponsorRepository();
    }
}
