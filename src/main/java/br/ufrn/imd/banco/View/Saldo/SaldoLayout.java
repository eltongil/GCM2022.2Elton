package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class SaldoLayout{
    private static VBox singleton = setColuna();
    public static VBox getInstance() {return singleton;}
    private static EscolherConta seletor;
    protected static VBox setColuna(){
        VBox colunaSaldo = new VBox();
        seletor = new EscolherConta();
        colunaSaldo.getChildren().add(seletor.getConta());
        colunaSaldo.getChildren().add(SaldoBotao.getInstance());
        colunaSaldo.getChildren().add(SaldoText.getInstance());
        return colunaSaldo;
    }
    public static Long getConta(){
        return Long.parseLong(seletor.getConta().getText());
    }
}