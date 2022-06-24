package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;

import java.math.BigDecimal;

public class ContaService {

    private final ContaRepository repository;
    private static final ContaService singleton =  new ContaService();

    private ContaService() {
        this.repository = ContaRepository.getInstance();
    }

    public static ContaService getInstance() {
        return singleton;
    }

    public String criarConta(String numero, String tipo, String valor) throws BadArgumentException {
        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        this.verificarSeExisteConta(numero);
        return criarContaPorTipo(numero, tipo, valor);
    }

    private String criarContaPorTipo(String numero, String tipo, String valor) throws BadArgumentException {
        long conta = Long.parseLong(numero);
        switch (tipo){
            case "Bonus":
                this.verificarValorComoDouble(valor);
                BigDecimal saldo = BigDecimal.valueOf(Double.parseDouble(valor));
                repository.addCliente(new ContaBonusModel(conta, saldo));
                return "Conta Bônus Criada";
            case "Poupança":
                repository.addCliente(new ContaPoupancaModel(conta));
                return  "Conta Poupança criada";
            default:
                repository.addCliente(new ContaModel(conta));
                return "Conta Padrão Criada";
        }
    }

    public String consultarSaldo(Long numero) throws BadArgumentException{
        this.verificarStringVazia(numero.toString());
        this.verificarStringNumero(numero.toString());
        ContaModel conta =  repository.getByNumero(numero);

        if(conta != null){
            return "$ "+ conta.getSaldo().toString();
        }else{
            throw new BadArgumentException("Conta inexistente.");
        }
    }

    public String transferencia(Long numeroOrigem, Long numeroDestino, BigDecimal valor) throws BadArgumentException {

        if (!this.repository.verificarSeContaExiste(numeroOrigem))
            throw new BadArgumentException("Conta do número de origem não existe");

        if (!this.repository.verificarSeContaExiste(numeroDestino))
            throw new BadArgumentException("Conta do número de destino não existe");

        ContaModel contaOrigem = this.repository.getByNumero(numeroOrigem);

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        ContaModel contaDestino = this.repository.getByNumero(numeroDestino);
        if (contaDestino instanceof ContaBonusModel) {
            long bonus = Math.floorDiv(valor.longValue(), 200L);
            ((ContaBonusModel) contaDestino).addBonus(bonus);
        }

        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        return "Transferência realizada com sucesso";
    }

    public String renderJuros(String numero, String valor) throws BadArgumentException {
        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        this.verificarStringVazia(valor);
        this.verificarStringDouble(valor);

        long contaNumero = Long.parseLong(numero);
        this.verificarSeNaoExisteConta(contaNumero);

        ContaModel conta = this.repository.getByNumero(contaNumero);
        if (conta instanceof ContaPoupancaModel)
            ((ContaPoupancaModel) conta).renderJuros(new BigDecimal(valor));
        else
            throw new BadArgumentException("Somente contas de poupança podem ter rendimentos");

        return "Juros rendidos com sucesso";
    }

    public String saque(Long numero, BigDecimal valor) throws BadArgumentException {

        this.verificarSeNaoExisteConta(numero);
        this.verificarvalorNegativo(valor);

        ContaModel conta = this.repository.getByNumero(numero);
        return this.saquePorTipoConta(conta, valor);
    }

    private String saquePorTipoConta(ContaModel conta, BigDecimal valor) throws BadArgumentException {
        if (conta instanceof ContaPoupancaModel){
            conta.setSaldo(conta.getSaldo().subtract(valor));
            return "Saque realizado c0om sucesso";
        } else {
            BigDecimal saldoFinal = conta.getSaldo().subtract(valor);
            BigDecimal limiteMinimo = BigDecimal.valueOf(-1000);
            if (saldoFinal.compareTo(limiteMinimo) < 0)
                throw new BadArgumentException("Não há saldo suficiente para realizar o saque");
            conta.setSaldo(saldoFinal);
            return "Saque realizado com sucesso";
        }
    }

    public String deposito(Long numero, BigDecimal valor) throws BadArgumentException {

        this.verificarvalorNegativo(valor);
        this.verificarSeNaoExisteConta(numero);

        ContaModel conta = this.repository.getByNumero(numero);
        conta.setSaldo(conta.getSaldo().add(valor));

        return "Depósito realizado com sucesso";
    }



    private void verificarValorComoDouble(String valor) throws BadArgumentException {

        if (valor == null || valor.isEmpty() || valor.isBlank())
            throw new BadArgumentException("Conta bônus deve ter um valor inicial");

        try {
            BigDecimal saldo = BigDecimal.valueOf(Double.parseDouble(valor));
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O valor apresentado não é um número válido");
        }
    }

    private void verificarSeExisteConta(String numero) throws BadArgumentException {
        long numeroConta = Long.parseLong(numero);
        if (this.repository.verificarSeContaExiste(numeroConta))
            throw new BadArgumentException("Já existe conta com esse número");
    }

    private void verificarSeNaoExisteConta(Long numero) throws BadArgumentException {
        if (!this.repository.verificarSeContaExiste(numero))
            throw new BadArgumentException("Não existe conta com esse número");
    }

    private void verificarStringNumero(String numero) throws BadArgumentException {
        try {
            Long.valueOf(numero);
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O numero da conta não pode conter letras ou caracteres especiais");
        }
    }

    private void verificarStringDouble(String numero) throws BadArgumentException {
        try {
            Double.valueOf(numero);
        } catch (NumberFormatException ex) {
            throw new BadArgumentException("O valor deve ser um número");
        }
    }

    private void verificarStringVazia(String numero) throws BadArgumentException {
        if (numero.isBlank())
            throw new BadArgumentException("O numero de conta informado é vazio");
    }

    private void verificarvalorNegativo(BigDecimal numero) throws  BadArgumentException {

        if (numero.compareTo(BigDecimal.ZERO) < 0)
            throw new BadArgumentException("Valores negativos não são válidos para essa operação");

    }

}
