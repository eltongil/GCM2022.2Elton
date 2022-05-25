package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class SaldoLayout{
    private static VBox singleton = setColuna();
    public static VBox getInstance() {return singleton;}
    private static EscolherConta seletor = new EscolherConta();
    protected static VBox setColuna(){
        VBox colunaSaldo = new VBox();
        colunaSaldo.getChildren().add(seletor.getContas());
        colunaSaldo.getChildren().add(SaldoBotao.getInstance());
        colunaSaldo.getChildren().add(SaldoText.getInstance());
        return colunaSaldo;
    }
}