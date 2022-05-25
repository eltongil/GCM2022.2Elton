package br.ufrn.imd.banco.View.Abstratos;

import javafx.scene.control.Button;

public abstract class BotaoAbstrato {
    private static final Button Criador = setButton();
    public static Button getInstance(){return Criador;}
    protected static Button setButton(){return null;}
}
