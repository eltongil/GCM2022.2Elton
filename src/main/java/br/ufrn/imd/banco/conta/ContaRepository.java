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

    public ContaModel addCliente(ContaModel nova) {
        clientes.add(nova);
        return nova;
    }

    public boolean verificarNumeroUtilizado(Long numero) {
        return clientes.stream().anyMatch(conta -> conta.getNumero().equals(numero));
    }

    public ArrayList<ContaModel> getLista(){return clientes;}
}