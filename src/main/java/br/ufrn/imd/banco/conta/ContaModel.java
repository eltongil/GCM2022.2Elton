package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaModel {

    protected Long numero;
    protected BigDecimal saldo;

    public ContaModel(long numero) {
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    @Override
    public String toString() {
        return "[numero=" + numero + "<> saldo=" + saldo + "]";
    }

}
