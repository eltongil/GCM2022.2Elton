package br.ufrn.imd.banco.conta;

import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class ContaController {

    private final ContaService service;

    public ContaController() {
        this.service = ContaService.getInstance();
    }

    @FXML
    public Label labelErro;

    @FXML
    public TextField campoNumeroConta;

    @FXML
    protected void adicionarConta() {
        String numero = campoNumeroConta.getText();
        try {
            this.service.addConta(numero);
        } catch (BadArgumentException e) {
            labelErro.setText(e.getMessage());
        }
    }

}