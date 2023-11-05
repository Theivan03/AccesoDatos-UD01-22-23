package model.services.torneo;

import model.entity.Torneo;

import java.sql.SQLException;
import java.util.List;

public interface ITorneoService {

    public List<Torneo> findAll() throws SQLException;
    public int save(Torneo torneo);
    public Torneo findByID(int id) throws SQLException;
    public boolean delete(int id);
    public boolean update (Torneo torneo);
}
