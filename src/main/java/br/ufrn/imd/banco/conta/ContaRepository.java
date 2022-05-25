package br.ufrn.imd.banco.conta;

import java.util.ArrayList;

public class ContaRepository {

    private final ArrayList<ContaModel> clientes =new ArrayList<>();

    private static final ContaRepository singleton = new ContaRepository();

    public static ContaRepository getInstance() {
        return singleton;
    }

    public ContaModel addCliente(ContaModel nova) {
        clientes.add(nova);
        return nova;
    }

    public boolean verificarNumeroUtilizado(Long numero) {
        return clientes.stream().anyMatch(conta -> conta.getNumero().equals(numero));
    }

    public ArrayList<ContaModel> getLista(){return clientes;}

    public ArrayList<Long> getNumeros(){
        ArrayList<Long> lista = new ArrayList<>();
        for (ContaModel conta : clientes){
            lista.add(conta.getNumero());
        }
        return lista;
    }
    
    public ContaModel getByNumero(Long numero){
        for(ContaModel conta : clientes){
            if (conta.getNumero().equals(numero)){
                return conta;
            }
        }
        return null;
    }
}