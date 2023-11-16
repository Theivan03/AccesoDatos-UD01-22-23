package model.services.torneo;

import model.entity.Torneo;

import java.util.List;
import java.util.UUID;

public interface ITorneoService {
    public void save (Torneo torneo);
    public Torneo findById(UUID codigo);
    public List<Torneo> findAll();
    public boolean delete (UUID codigo);
    public boolean update (Torneo torneo);
}
