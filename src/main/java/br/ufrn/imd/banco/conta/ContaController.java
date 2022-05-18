package br.ufrn.imd.banco.conta;

public class ContaController {
    public ContaModel criarConta(long numero){
        ContaModel novo = new ContaModel(numero);
        ContaRepository.getInstance().addCliente(novo);
        return novo;
    }
}
