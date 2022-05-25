package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

public class ContaController {

    private static final ContaService service = ContaService.getInstance();
    private static final ContaController singleton = new ContaController();

    public static ContaController getInstance(){return singleton;}

    public static String adicionarConta(String numero) {        
        try {
            service.addConta(numero);
            return "Conta adicionada.";
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}