package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class AbaJuros extends Aba{

    public AbaJuros() {

        super("Render Juros", "Juros", "Juros", true);
        valor.setPromptText("Juros");

    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                texto.setText(ContaController.getInstance().renderJuros(conta.getText(), valor.getText()));
            }
        });
    }
}
