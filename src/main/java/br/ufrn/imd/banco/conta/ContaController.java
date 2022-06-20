package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

public class ContaController {

    private static final ContaService service = ContaService.getInstance();
    private static final ContaController singleton = new ContaController();

    public static ContaController getInstance() {
        return singleton;
    }

    public static String adicionarConta(String numero, String tipo) {
        try {
            String resp = service.addConta(numero, tipo);
            return resp;
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String deposito(Long numero, BigDecimal valor) throws BadArgumentException {
        try {
            return service.deposito(numero, valor);
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String saque(Long numero, BigDecimal valor) {
        try {
            return service.saque(numero, valor);
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String transferencia(Long numeroOrigem, Long numeroDestino, BigDecimal valor){
        try {
            return service.transferencia(numeroOrigem, numeroDestino, valor);
        } catch (BadArgumentException e) {
            return e.getMessage();
        }
    }

    public String renderJuros(String numero, String valor) {

        try {
            String resp = service.renderJuros(numero, valor);
            return resp;
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}