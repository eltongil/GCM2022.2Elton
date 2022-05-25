package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class SaldoLayout{
    private static VBox singleton = setColuna();
    public static VBox getInstance() {return singleton;}
    protected static VBox setColuna(){
        VBox colunaSaldo = new VBox();
        colunaSaldo.getChildren().add(EscolherConta.getInstance());
        colunaSaldo.getChildren().add(SaldoBotao.getInstance());
        colunaSaldo.getChildren().add(SaldoText.getInstance());
        return colunaSaldo;
    }
}