package br.ufrn.imd.banco.View.Saque;

import br.ufrn.imd.banco.View.EscolherConta;
import javafx.scene.layout.VBox;

public class SaqueLayout {
    private static VBox singleton = setColuna();
    public static VBox getInstance(){return singleton;}
    private static EscolherConta seletor;
    private static VBox setColuna(){
        VBox coluna = new VBox();
        seletor = new EscolherConta();
        coluna.getChildren().add(seletor.getConta());
        coluna.getChildren().add(SaqueValor.getInstance());
        coluna.getChildren().add(SaqueBotao.getInstance());
        coluna.getChildren().add(SaqueText.getInstance());
        return coluna;
    }
    public static Long getConta(){
        return Long.parseLong(seletor.getConta().getText());
    }
}
