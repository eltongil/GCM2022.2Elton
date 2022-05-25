package br.ufrn.imd.banco.View.Deposito;

import javafx.scene.control.Tab;

public class DepositoTab {
    private static Tab singleton = setTab();
    public static Tab getInstance() {return singleton;}
    private static Tab setTab(){
        Tab aba = new Tab();
        aba.setText("Deposito");
        aba.setContent(DepositoLayout.getInstance());
        return aba;
    }
    
}
