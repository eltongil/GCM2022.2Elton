package br.ufrn.imd.banco;

import br.ufrn.imd.banco.View.ConfigStage;
import br.ufrn.imd.banco.View.PainelDeAbas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BancoMain extends Application {

    public static void main(String[] args){launch();}

    @Override
    public void start(Stage stage) throws Exception {
        Pane layoutPrincipal = new Pane();
        layoutPrincipal.getChildren().add(PainelDeAbas.getInstance());
        Scene cena = new Scene(layoutPrincipal);
        ConfigStage.configurarStage(stage);
        stage.setScene(cena);
        stage.show();
    }
}
