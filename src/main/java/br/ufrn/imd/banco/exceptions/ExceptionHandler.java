package br.ufrn.imd.banco.exceptions;

import java.math.BigDecimal;

import br.ufrn.imd.banco.conta.ContaModel;
import br.ufrn.imd.banco.conta.ContaRepository;

public class ExceptionHandler {
    private final ContaRepository repository = ContaRepository.getInstance();

    public void verificarSeExisteConta(String numero) throws BadArgumentException {
        long numeroConta = Long.parseLong(numero);
        if (this.repository.verificarSeContaExiste(numeroConta))
            throw new BadArgumentException("Já existe conta com esse número");
    }

    public void verificarSeNaoExisteConta(Long numero) throws BadArgumentException {
        if (!this.repository.verificarSeContaExiste(numero))
            throw new BadArgumentException("Não existe conta com esse número");
    }

    public void verificarStringNumero(String numero) throws BadArgumentException {
        try {
            Long.valueOf(numero);
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O numero da conta não pode conter letras ou caracteres especiais");
        }
    }

    public void verificarStringVazia(String numero) throws BadArgumentException {
        if (numero.isBlank())
            throw new BadArgumentException("O numero informado é vazio");
    }

    public void verificarSaldoSuficiente(ContaModel conta, BigDecimal valor) throws BadArgumentException {
        if (conta.getSaldo().compareTo(valor) == -1)
            throw new BadArgumentException("Saldo insuficiente");
    }

    public void verificarValorPositivo(BigDecimal valor) throws BadArgumentException {
        if (valor.compareTo(BigDecimal.ZERO) == -1)
            throw new BadArgumentException("O valor financeiro não pode ser negativo.");
    }
}
