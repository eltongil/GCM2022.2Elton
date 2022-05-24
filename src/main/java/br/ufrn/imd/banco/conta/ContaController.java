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
    public Label saldoLabel;

    @FXML
    public Label labelErroSaldo;

    @FXML
    public TextField campoNumeroConta;

    @FXML
    public TextField campoNumeroContaSaldo;

    @FXML
    protected void adicionarConta() {
        String numero = campoNumeroConta.getText();
        try {
            this.service.adicionarConta(numero);
        } catch (BadArgumentException e) {
            labelErro.setText(e.getMessage());
        }
    }

    @FXML
    public void verificarSaldo() {
        String numero = campoNumeroContaSaldo.getText();
        try {
            BigDecimal value = this.service.recuperarSaldo(numero);
            this.saldoLabel.setText(value.toPlainString());
        } catch (BadArgumentException e) {
            labelErroSaldo.setText(e.getMessage());
        }
    }

}