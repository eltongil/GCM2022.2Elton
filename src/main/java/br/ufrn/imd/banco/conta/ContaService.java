package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

import java.math.BigDecimal;

public class ContaService {

    private final ContaRepository repository;
    private static final ContaService singleton =  new ContaService();

    public static ContaService getInstance() {
        return singleton;
    }

    private ContaService() {
        this.repository = ContaRepository.getInstance();
    }


    public void adicionarConta(String numero) throws BadArgumentException {

        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        long numeroConta = Long.parseLong(numero);

        if (this.verificarExistenciaConta(numeroConta))
            this.repository.salvar(new ContaModel(numeroConta));
        else
            throw new BadArgumentException("Já existe conta com esse número");
    }

    public BigDecimal recuperarSaldo(String numero) throws BadArgumentException{
        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        long numeroConta = Long.parseLong(numero);
        ContaModel conta = this.repository.encontrar(numeroConta).orElseThrow(() -> new BadArgumentException("Essa conta não existe"));
        return conta.getSaldo();
    }


    private void verificarStringNumero(String numero) throws BadArgumentException {
        try {
            Long.valueOf(numero);
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O numero da conta não pode conter letras ou caracteres especiais");
        }
    }

    private void verificarStringVazia(String numero) throws BadArgumentException {
        if (numero.isBlank())
            throw new BadArgumentException("O numero de conta informado é vazio");
    }

    private Boolean verificarExistenciaConta(Long numero) {
        return !repository.verificarNumeroUtilizado(numero);
    }

}
