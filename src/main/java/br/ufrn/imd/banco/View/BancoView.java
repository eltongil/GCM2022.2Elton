package br.ufrn.imd.banco.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BancoView extends Application {

    public static void main(String[] args){launch();}

    @Override
    public void start(Stage stage) throws Exception {
        Pane layoutPrincipal = new Pane();
        layoutPrincipal.getChildren().add(PainelDeAbas.getInstance());
        Scene cena = new Scene(layoutPrincipal);
        ConfigStage.configurarStage(stage);
        ConfigCena.configurar(cena);
        stage.setScene(cena);
        stage.show();
    }
}
