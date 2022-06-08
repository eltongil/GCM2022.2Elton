package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AbaDeposito extends Aba {

    public AbaDeposito() {
        super("Depositar", "Fazer depositos em conta", "Deposito", true, false);
    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    texto.setText(
                            ContaController.deposito(
                                    getNumero(),
                                    getValor()));
                } catch (BadArgumentException e) {
                    texto.setText(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

}
