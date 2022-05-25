package br.ufrn.imd.banco.View.Saque;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class SaqueLayout {
    private static VBox singleton = setColuna();
    public static VBox getInstance(){return singleton;}
    private static VBox setColuna(){
        VBox coluna = new VBox();
        coluna.getChildren().add(EscolherConta.getInstance());
        coluna.getChildren().add(SaqueValor.getInstance());
        coluna.getChildren().add(SaqueBotao.getInstance());
        coluna.getChildren().add(SaqueText.getInstance());
        return coluna;
    }
}
