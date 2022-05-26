package br.ufrn.imd.banco.View.Criador;

import javafx.scene.layout.VBox;

public class CriadorLayout{
    private static VBox singleton = setColuna();
    public static VBox getInstance() {return singleton;}
    protected static VBox setColuna() {
        VBox alocarColuna = new VBox();
        alocarColuna.getChildren().add(EntradaCriador.getInstance());
        alocarColuna.getChildren().add(CriadorBotao.getInstance());
        alocarColuna.getChildren().add(CriadorText.getInstance());
        return alocarColuna;
    }
}
