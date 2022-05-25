package br.ufrn.imd.banco.View.Deposito;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class DepositoLayout {
    private static VBox singleton = setColuna();
    public static VBox getInstance(){return singleton;}
    private static EscolherConta contaSelecionada = new EscolherConta();
    private static VBox setColuna(){
        VBox nova = new VBox();
        nova.getChildren().add(contaSelecionada.getConta());
        nova.getChildren().add(DepositoValor.getInstance());
        nova.getChildren().add(DepositoBotao.getInstance());
        nova.getChildren().add(DepositoText.getInstance());
        return nova;
    }
    public static Long getSelecionada(){
        return  Long.parseLong(
                    contaSelecionada.getConta().getText()
                );
    }
}
