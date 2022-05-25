package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.Abstratos.TabAbstrata;
import javafx.scene.control.Tab;

public class SaldoTab extends TabAbstrata {
    protected static Tab setTab(){
        Tab Saldo = new Tab();
        Saldo.setContent(SaldoLayout.getInstance());
        Saldo.setText("Saldo");
        return Saldo;
    }
}
