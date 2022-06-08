package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;
import br.ufrn.imd.banco.exceptions.ExceptionHandler;

import java.math.BigDecimal;

public class ContaService {

    private final ContaRepository repository;
    private static final ContaService singleton = new ContaService();
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    private ContaService() {
        this.repository = ContaRepository.getInstance();
    }

    public static ContaService getInstance() {
        return singleton;
    }

    public String addConta(String numero, String tipo) throws BadArgumentException {
        exceptionHandler.verificarStringVazia(numero);
        exceptionHandler.verificarStringNumero(numero);
        exceptionHandler.verificarSeExisteConta(numero);

        long conta = Long.parseLong(numero);
        String resp = "";
        switch (tipo) {
            case "Bonus":
                repository.addCliente(new ContaBonusModel(conta));
                resp = "Conta Bônus Criada";
                break;
            default:
                repository.addCliente(new ContaModel(conta));
                resp = "Conta Padrão Criada";
                break;
        }
        return resp;
    }

    public String deposito(Long numero, BigDecimal valor) throws BadArgumentException {

        exceptionHandler.verificarSeNaoExisteConta(numero);
        exceptionHandler.verificarValorPositivo(valor);
        ContaModel conta = this.repository.getByNumero(numero);

        if (conta instanceof ContaBonusModel) {
            long bonus = Math.floorDiv(valor.longValue(), 100l);
            ((ContaBonusModel) conta).addBonus(bonus);
        }

        conta.setSaldo(conta.getSaldo().add(valor));

        String resp = conta.getNumero().toString();
        return resp;
    }

    public String saque(Long numero, BigDecimal valor) throws BadArgumentException {
        exceptionHandler.verificarSeNaoExisteConta(numero);
        ContaModel conta = this.repository.getByNumero(numero);
        exceptionHandler.verificarValorPositivo(valor);
        exceptionHandler.verificarSaldoSuficiente(conta, valor);
        conta.saque(valor);
        return numero.toString();
    }

    public String consultarSaldo(Long numero) throws BadArgumentException {
        exceptionHandler.verificarStringVazia(numero.toString());
        exceptionHandler.verificarStringNumero(numero.toString());
        ContaModel conta = repository.getByNumero(numero);

        if (conta != null) {
            return "$ " + conta.getSaldo().toString();
        } else {
            throw new BadArgumentException("Conta inexistente.");
        }
    }

    public String transferencia(Long numeroOrigem, Long numeroDestino, BigDecimal valor) throws BadArgumentException {

        if (!this.repository.verificarSeContaExiste(numeroOrigem))
            throw new BadArgumentException("Conta do número de origem não existe");

        if (!this.repository.verificarSeContaExiste(numeroDestino))
            throw new BadArgumentException("Conta do número de destino não existe");

        exceptionHandler.verificarValorPositivo(valor);
        ContaModel contaOrigem = this.repository.getByNumero(numeroOrigem);
        exceptionHandler.verificarSaldoSuficiente(contaOrigem, valor);
        contaOrigem.saque(valor);

        ContaModel contaDestino = this.repository.getByNumero(numeroDestino);
        if (contaDestino instanceof ContaBonusModel) {
            long bonus = Math.floorDiv(valor.longValue(), 200l);
            ((ContaBonusModel) contaDestino).addBonus(bonus);
        }

        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        return "Transferência realizada com sucesso";
    }

}
