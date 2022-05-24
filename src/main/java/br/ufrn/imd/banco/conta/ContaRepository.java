package br.ufrn.imd.banco.conta;

import java.util.ArrayList;
import java.util.Optional;

public class ContaRepository {

    private final ArrayList<ContaModel> clientes;

    private static final ContaRepository singleton = new ContaRepository();

    public static ContaRepository getInstance() {
        return singleton;
    }

    private ContaRepository() {
        clientes = new ArrayList<>();
    }

    public ContaModel salvar(ContaModel nova) {
        clientes.add(nova);
        return nova;
    }

    public Optional<ContaModel> encontrar(Long numero) {
        return this.clientes.stream().filter(conta -> conta.getNumero().equals(numero)).findAny();
    }

    public boolean verificarNumeroUtilizado(Long numero) {
        return clientes.stream().anyMatch(conta -> conta.getNumero().equals(numero));
    }

}