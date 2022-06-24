package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AbaCriador extends Aba {

    public AbaCriador() {
        super("Criar", "Criação de contas", "Nova Conta", true);
    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto.setText(
                        ContaController.adicionarConta(conta.getText(), valor.getText()));
            }
        });
    }

}
