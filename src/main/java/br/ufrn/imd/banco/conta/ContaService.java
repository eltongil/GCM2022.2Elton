package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaService {
    public ContaModel checarNumero(long numero) {
        ContaRepository repository = ContaRepository.getInstance();
        ContaModel novaContaModel;
        if (numero > 0) {
            novaContaModel = new ContaModel(numero);
            novaContaModel.setSaldo(new BigDecimal(0));
            repository.addCliente(novaContaModel);
        } else {
            return null;
        }
        return novaContaModel;
    }
}
