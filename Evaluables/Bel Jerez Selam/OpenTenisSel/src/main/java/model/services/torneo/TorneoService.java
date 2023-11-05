package model.services.torneo;


import model.repository.Torneo.ITorneoRepository;
import model.repository.Torneo.TorneoRepository;

public class TorneoService implements ITorneoService{
    private ITorneoRepository iTorneoRepository;

    public TorneoService() {
        iTorneoRepository = new TorneoRepository();
    }
}
