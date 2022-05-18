package br.ufrn.imd.banco.conta;

public class ContaService {
    public ContaModel checarNumero(long numero){
        ContaRepository repository = ContaRepository.getInstance();
        ContaModel novaContaModel;
        if (numero > 0){
            novaContaModel = new ContaModel(numero);
            repository.addCliente(novaContaModel);
        }else{
            return null;
        }
        return novaContaModel;
    }
}
