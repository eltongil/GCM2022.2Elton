package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Abstratos.TabAbstrata;
import javafx.scene.control.Tab;

public class CriadorTab extends TabAbstrata {
    protected static Tab setTab(){
        Tab aba = new Tab();
        aba.setText("Nova Conta");
        aba.setContent(CriadorLayout.getInstance());
        return aba;
    }
}
