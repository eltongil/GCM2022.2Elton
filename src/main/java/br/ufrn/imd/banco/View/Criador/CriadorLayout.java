package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.ColunaInterface;
import javafx.scene.layout.VBox;

public class CriadorLayout implements ColunaInterface {
    private static VBox Coluna = new VBox();

    @Override
    private void setColuna() {
        if(Coluna.getChildren().size()==0){
            Coluna.getChildren().add(EntradaCriador.getInstance());

        }
    }

    @Override
    public static VBox getInstance() {
        return null;
    }
}
