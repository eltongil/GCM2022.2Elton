package br.ufrn.imd.banco.View.Abstratos;

import javafx.scene.layout.VBox;

public abstract class ColunaAbstrata {
    private static VBox coluna = setColuna();
    public static VBox getInstance() {return coluna;}
    protected static VBox setColuna() {return null;}
}
