package br.ufrn.imd.banco.conta;

import java.util.ArrayList;

import br.ufrn.imd.banco.View.Saldo.EntradaSaldo;
import br.ufrn.imd.banco.exceptions.BadArgumentException;

public class ContaRepository {

    private final ArrayList<ContaModel> clientes =new ArrayList<>();

    private static final ContaRepository singleton = new ContaRepository();

    public static ContaRepository getInstance() {
        return singleton;
    }

    public ContaModel addCliente(ContaModel nova) {
        clientes.add(nova);
        EntradaSaldo.getInstance().getItems().add(nova.getNumero());
        return nova;
    }

    public boolean verificarNumeroUtilizado(Long numero) {
        for(ContaModel conta : clientes){
            if(conta.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<ContaModel> getLista(){return clientes;}

    public ArrayList<Long> getNumeros(){
        ArrayList<Long> lista = new ArrayList<>();
        for (ContaModel conta : clientes){
            lista.add(conta.getNumero());
        }
        return lista;
    }
    
    public ContaModel getByNumero(Long numero) throws BadArgumentException{
        for(ContaModel conta : clientes){
            if (conta.getNumero().equals(numero)){
                return conta;
            }
        }
        throw new BadArgumentException("Numero não cadastrado");
    }
}