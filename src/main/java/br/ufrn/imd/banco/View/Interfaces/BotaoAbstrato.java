package br.ufrn.imd.banco.View.Interfaces;

import br.ufrn.imd.banco.View.Criador.CriadorLabel;
import br.ufrn.imd.banco.View.Criador.EntradaCriador;
import br.ufrn.imd.banco.View.OuvinteBotao;
import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class BotaoAbstrato {
    private static final Button Criador = setButton();
    public static Button getInstance(){return Criador;}
    protected static Button setButton(){return null;}
}
