package br.ufrn.imd.banco.View.Saque;

import javafx.scene.control.Tab;

public class SaqueTab {
    private static Tab singleton = setTab();
    public static Tab getInstance(){return singleton;}
    private static Tab setTab(){
        Tab nova = new Tab();
        nova.setText("Saque");
        nova.setContent(SaqueLayout.getInstance());
        return nova;
    }
}
