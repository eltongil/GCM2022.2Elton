package br.ufrn.imd.banco.View.Abstratos;

import javafx.scene.control.Tab;

public abstract class TabAbstrata {
    private static Tab aba = setTab();
    protected static Tab setTab(){return null;}
    public static Tab getInstance() {return aba;}
}
