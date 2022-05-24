package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.Interfaces.TabInterface;
import javafx.scene.control.Tab;

public class SaldoTab implements TabInterface {
    private static Tab abaSaldo = setTab();
    private static Tab setTab(){
        Tab Saldo = new Tab();

        return Saldo;
    }
}
