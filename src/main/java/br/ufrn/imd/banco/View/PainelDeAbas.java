package br.ufrn.imd.banco.View;

import javafx.scene.control.TabPane;

public class PainelDeAbas {
    private static TabPane painel = new TabPane();
    public static TabPane getInstance(){
        return painel;
    }
}
