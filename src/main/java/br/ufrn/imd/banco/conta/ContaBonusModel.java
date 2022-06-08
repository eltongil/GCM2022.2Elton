package br.ufrn.imd.banco.conta;

public class ContaBonusModel extends ContaModel {

    protected Long bonus;

    public ContaBonusModel(long numero) {
        super(numero);
        this.bonus = 10l;
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
