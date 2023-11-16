package model.services.contrato;

import model.entity.Contrato;
import model.repository.Contrato.ContratoRepository;
import model.repository.Contrato.IContratoRepository;

public class ContratoService implements IContratoService{

    private IContratoRepository iContratoRepository;

    public ContratoService() {
        iContratoRepository = new ContratoRepository();
    }

    @Override
    public void save(Contrato contrato) {
        iContratoRepository.save(contrato);
    }
}
