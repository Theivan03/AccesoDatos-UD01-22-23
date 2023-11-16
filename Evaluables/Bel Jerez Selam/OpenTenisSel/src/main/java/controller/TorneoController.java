package controller;

import model.entity.Torneo;
import model.services.torneo.ITorneoService;
import model.services.torneo.TorneoService;

import java.util.List;
import java.util.UUID;

public class TorneoController {
    private ITorneoService iTorneoService;

    public TorneoController() {
        this.iTorneoService = new TorneoService();
    }

    public void save(Torneo torneo) {
        iTorneoService.save(torneo);
    }

    public List<Torneo> findAll() {
        return iTorneoService.findAll();
    }

    public Torneo findById(UUID id) {
        return iTorneoService.findById(id);
    }

    public boolean update(Torneo torneo) {
        return iTorneoService.update(torneo);
    }

    public boolean delete(UUID id){
        return iTorneoService.delete(id);
    }
}
