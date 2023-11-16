package model.services.torneo;


import model.entity.Torneo;
import model.repository.Torneo.ITorneoRepository;
import model.repository.Torneo.TorneoRepository;

import java.util.List;
import java.util.UUID;

public class TorneoService implements ITorneoService{

    private ITorneoRepository iTorneoRepository;

    public TorneoService() {
        iTorneoRepository = new TorneoRepository();
    }


    @Override
    public void save(Torneo torneo) {
        iTorneoRepository.save(torneo);
    }

    @Override
    public Torneo findById(UUID codigo) {
       return iTorneoRepository.findById(codigo);
    }

    @Override
    public List<Torneo> findAll() {
        return iTorneoRepository.findAll();
    }

    @Override
    public boolean delete(UUID codigo) {
        return iTorneoRepository.delete(codigo);
    }

    @Override
    public boolean update(Torneo torneo) {
        return iTorneoRepository.update(torneo);
    }
}
