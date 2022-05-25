package br.ufrn.imd.banco.View.Criador;

import javafx.scene.control.Tab;

public class CriadorTab{
    private static Tab singleton = setTab();
    public static Tab getInstance() {return singleton;}
    private static Tab setTab(){
        Tab aba = new Tab();
        aba.setText("Nova Conta");
        aba.setContent(CriadorLayout.getInstance());
        return aba;
    }
}
