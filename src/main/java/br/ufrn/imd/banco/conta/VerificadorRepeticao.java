package br.ufrn.imd.banco.conta;

public class VerificadorRepeticao {
    public static boolean verificar(long numero){
        ContaRepository repository = ContaRepository.getInstance();
        for(Long num : repository.getNumeros()){
            if(num==numero) return false;
        }
        return true;
    }
}
