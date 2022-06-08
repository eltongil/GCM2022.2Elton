package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.List;

public class AbaCriador extends Aba {

    private ToggleGroup group;

    private RadioButton padraoRadioButton;
    private RadioButton bonusRadioButton;

    public AbaCriador() {
        super("Criar", "Criação de contas", "Nova Conta", false);

        coluna.getChildren().remove(botao);
        coluna.getChildren().remove(texto);

        bonusRadioButton = new RadioButton("Bonus");
        padraoRadioButton = new RadioButton("Padrão");
        padraoRadioButton.setSelected(true);

        this.group = new ToggleGroup();
        padraoRadioButton.setToggleGroup(group);
        bonusRadioButton.setToggleGroup(group);

        coluna.getChildren().addAll(padraoRadioButton, bonusRadioButton);
        coluna.getChildren().addAll(botao, texto);

    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto.setText(
                        ContaController.adicionarConta(conta.getText(), ((RadioButton)group.getSelectedToggle()).getText()));
            }
        });
    }

}
