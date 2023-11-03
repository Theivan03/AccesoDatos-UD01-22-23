package model.services.tenista;

import model.repository.Tenista.ITenistaRepository;
import model.repository.Tenista.TenistaRepository;

public class TenistaService implements ITenistaService {

    private ITenistaRepository iTenistaRepository;

    public TenistaService() {
        iTenistaRepository = new TenistaRepository();
    }
}
