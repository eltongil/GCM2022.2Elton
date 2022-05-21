package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    public ContaModel criarConta(Long numero){
        return this.service.addClient(numero);
    }

}
