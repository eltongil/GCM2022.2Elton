package br.ufrn.imd.banco.conta;

import java.util.ArrayList;

public class ContaRepository {
    private ArrayList<ContaModel> clientes;
    private static ContaRepository singleton = new ContaRepository();
    public static ContaRepository getInstance(){
        return singleton;

    }
    private ContaRepository(){
        clientes =  new ArrayList<ContaModel>();
    }
    public void addCliente(ContaModel nova){
        clientes.add(nova);
    }    
    public ArrayList<Long> getNumeros(){
        ArrayList<Long> listaDeNumeros = new ArrayList<Long>();
        for(ContaModel conta : clientes){
            listaDeNumeros.add(conta.getNumero());
        }
        return listaDeNumeros;
    }
}
