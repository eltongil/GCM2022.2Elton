package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class AbaSaque extends Aba {

    public AbaSaque() {
        super("Efetuar Saque", "Saque da conta", "Saque", true);
    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContaController.getInstance();
                texto.setText(
                        ContaController.saque(
                                getNumero(),
                                getValor()));
            }
        });
    }

}
