package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaModel {
    private Long numero;
    private BigDecimal saldo;
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
    @Override
    public String toString() {
        return "[numero=" + numero + "<> saldo=" + saldo + "]";
    }

}
