package br.ufrn.imd.banco.View;

import br.ufrn.imd.banco.View.Criador.CriadorTab;
import javafx.scene.control.TabPane;

public class PainelDeAbas {
    private static TabPane painel = setPainel();

    private static TabPane setPainel(){
        TabPane painel = new TabPane();
        painel.setMinWidth(300);
        painel.getTabs().add(CriadorTab.getInstance());

        return painel;
    }
    public static TabPane getInstance(){
        return painel;
    }
}
