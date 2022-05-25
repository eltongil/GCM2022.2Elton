package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Abstratos.ColunaAbstrata;
import javafx.scene.layout.VBox;

public class CriadorLayout extends ColunaAbstrata {
    protected static VBox setColuna() {
        VBox alocarColuna = new VBox();
        alocarColuna.getChildren().add(EntradaCriador.getInstance());
        alocarColuna.getChildren().add(CriadorBotao.getInstance());
        alocarColuna.getChildren().add(CriadorLabel.getInstance());
        return alocarColuna;
    }
}
