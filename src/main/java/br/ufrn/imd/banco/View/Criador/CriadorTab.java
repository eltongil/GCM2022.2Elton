package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.TabInterface;
import javafx.scene.control.Tab;

public class CriadorTab implements TabInterface {
    private static Tab abaCriador = setTab();
    private static Tab setTab(){
        Tab aba = new Tab();
        aba.setText("Nova Conta");
        aba.setContent(CriadorLayout.getInstance());
        return aba;
    }
    public static Tab getInstance(){
        return abaCriador;
    }
}
