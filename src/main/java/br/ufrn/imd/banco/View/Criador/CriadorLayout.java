package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.ColunaInterface;
import javafx.scene.layout.VBox;

public class CriadorLayout implements ColunaInterface {
    private static VBox Coluna = CriadorLayout.setColuna();

    private static VBox setColuna() {
        VBox alocarColuna = new VBox();
        alocarColuna.getChildren().add(EntradaCriador.getInstance());
        alocarColuna.getChildren().add(CriadorBotao.getInstance());
        alocarColuna.getChildren().add(CriadorLabel.getInstance());
        return alocarColuna;
    }

    public static VBox getInstance() {return Coluna;}
}
