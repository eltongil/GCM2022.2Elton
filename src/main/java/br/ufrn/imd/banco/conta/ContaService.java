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

    public void addConta(String numero) throws BadArgumentException {
        this.verificarStringVazia(numero);
        this.verificarStringNumero(numero);
        long numeroConta = Long.parseLong(numero);

        if (this.verificarNumeroDisponivel(numeroConta))
            repository.addCliente(new ContaModel(numeroConta));
        else
            throw new BadArgumentException("Já existe conta com esse número");
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

    public Boolean verificarNumeroDisponivel(Long numero) {
        return !repository.verificarNumeroUtilizado(numero);
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

        if (!this.repository.verificarNumeroUtilizado(numeroOrigem))
            throw new BadArgumentException("Conta do número de origem não existe");

        if (!this.repository.verificarNumeroUtilizado(numeroDestino))
            throw new BadArgumentException("Conta do número de destino não existe");

        ContaModel contaOrigem = this.repository.getByNumero(numeroOrigem);

        if (contaOrigem.getSaldo().compareTo(valor) < 0)
            throw new BadArgumentException("Não existe saldo suficiente para realizar essa transferência");

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        ContaModel contaDestino = this.repository.getByNumero(numeroDestino);
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        return "Transferência realizada com sucesso";
    }

    public String saque(Long numero, BigDecimal valor) throws BadArgumentException {

        if ( this.verificarNumeroDisponivel(numero) )
            throw new BadArgumentException("Não existe Conta com esse número");

        if (valor.compareTo(BigDecimal.ZERO) < 0)
            throw new BadArgumentException("Não é possível sacar valores negativos");

        ContaModel conta = this.repository.getByNumero(numero);

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new BadArgumentException("O valor do saque deve ser menor que o saldo da conta");
        else {
            conta.setSaldo(conta.getSaldo().subtract(valor));
            return "Saque realizado com sucesso";
        }
    }
}
