package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

public class ContaController {

    private static final ContaService service = ContaService.getInstance();
    private static final ContaController singleton = new ContaController();

    public static ContaController getInstance() {
        return singleton;
    }

    public static String adicionarConta(String numero) {
        try {
            service.addConta(numero);
            return "Conta adicionada.";
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String deposito(Long numero, BigDecimal valor) throws BadArgumentException {
        try {
            ContaRepository.getInstance().getByNumero(numero).deposito(valor);
            return "Saldo da conta " + numero + " atualizado";
        } catch (BadArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String saque(Long numero, BigDecimal valor) {
        try {
            if (ContaRepository.getInstance().getByNumero(numero).saque(valor)) {
                return "Saque efetuado.";
            } else {
                return "Saldo insuficiente";
            }
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

}