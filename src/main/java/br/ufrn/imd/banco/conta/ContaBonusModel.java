package br.ufrn.imd.banco.conta;

import java.math.BigDecimal;

public class ContaBonusModel extends ContaModel {

    protected Long bonus;

    public ContaBonusModel(long numero, BigDecimal saldo) {
        super(numero);
        this.bonus = 10l;
        this.saldo = saldo;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public void addBonus(Long bonus){
        this.bonus += bonus;
    }

}
