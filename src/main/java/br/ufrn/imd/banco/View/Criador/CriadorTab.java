package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.ColunaInterface;
import br.ufrn.imd.banco.View.Interfaces.TabInterface;
import javafx.scene.control.Tab;

public class CriadorTab implements TabInterface {
    private static Tab abaCriador = new Tab("Nova Conta", ColunaInterface.getInstance());

    public static Tab getInstance(){
        return abaCriador;
    }
}
