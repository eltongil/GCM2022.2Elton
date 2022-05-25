package br.ufrn.imd.banco.View.Deposito;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class DepositoLayout {
    private static VBox singleton = setColuna();
    public static VBox getInstance(){return singleton;}
    private static VBox setColuna(){
        VBox nova = new VBox();
        nova.getChildren().add(EscolherConta.getInstance());
        nova.getChildren().add(DepositoValor.getInstance());
        nova.getChildren().add(DepositoBotao.getInstance());
        nova.getChildren().add(DepositoText.getInstance());
        return nova;
    }
}
