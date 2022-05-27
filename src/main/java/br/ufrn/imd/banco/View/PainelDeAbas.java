package br.ufrn.imd.banco.View;

import br.ufrn.imd.banco.View.Abas.*;
import javafx.scene.control.TabPane;

public class PainelDeAbas {
    private static TabPane painel = setPainel();

    private static TabPane setPainel() {
        TabPane painel = new TabPane();
        painel.setMinWidth(400);
        painel.getTabs().add((new AbaCriador()).getAba());
        painel.getTabs().add((new AbaSaldo()).getAba());
        painel.getTabs().add((new AbaDeposito()).getAba());
        painel.getTabs().add((new AbaSaque()).getAba());
        painel.getTabs().add((new AbaTransferencia().getAba()));
        return painel;
    }

    public static TabPane getInstance() {
        return painel;
    }
}
