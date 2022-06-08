package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaPoupancaModel extends ContaModel{


    public ContaPoupancaModel(long numero) {
        super(numero);
    }

    public void renderJuros(BigDecimal taxa) {
        BigDecimal taxaPerCent = taxa.divide(BigDecimal.valueOf(100l));
        taxaPerCent = taxaPerCent.add(BigDecimal.valueOf(1));
        this.setSaldo(this.getSaldo().multiply(taxaPerCent));
    }
}
