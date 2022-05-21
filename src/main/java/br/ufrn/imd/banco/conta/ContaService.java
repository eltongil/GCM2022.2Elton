package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;
import java.util.Optional;

public class ContaService {

    private ContaRepository repository;

    public ContaService() {
        ContaRepository repository = ContaRepository.getInstance();
    }

    public ContaModel addClient(Long numero) {
        if (this.verificarNumeroDisponivel(numero))
            return repository.addCliente(new ContaModel(numero));
        else
            return null;
    }

    public Boolean verificarNumeroDisponivel(Long numero) {
        return !repository.verificarNumeroUtilizado(numero);
    }
}
