package br.ufrn.imd.banco.View.Saldo;

import javafx.scene.layout.VBox;

public class SaldoLayout{
    private static VBox singleton = setColuna();
    public static VBox getInstance() {return singleton;}
    protected static VBox setColuna(){
        VBox colunaSaldo = new VBox();
        colunaSaldo.getChildren().add(EntradaSaldo.getInstance());
        colunaSaldo.getChildren().add(SaldoBotao.getInstance());
        colunaSaldo.getChildren().add(SaldoText.getInstance());
        return colunaSaldo;
    }
}