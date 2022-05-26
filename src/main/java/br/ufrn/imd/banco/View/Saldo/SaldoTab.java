package br.ufrn.imd.banco.View.Saldo;

import javafx.scene.control.Tab;

public class SaldoTab{
    private static Tab singleton = setTab();
    public static Tab getInstance() {return singleton;}
    protected static Tab setTab(){
        Tab Saldo = new Tab();
        Saldo.setContent(SaldoLayout.getInstance());
        Saldo.setText("Saldo");
        return Saldo;
    }
}
