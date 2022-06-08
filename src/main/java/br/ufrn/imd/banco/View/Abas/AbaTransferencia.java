package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AbaTransferencia extends Aba {

    public AbaTransferencia() {
        super("Transferir", "Transferir valores entre contas.", "Transferência", true, true);
    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContaController.getInstance();
                texto.setText(
                        ContaController.transferencia(
                                getNumero(),
                                getNumeroDestino(),
                                getValor()));
            }
        });
    }

    private Long getNumeroDestino() {
        return Long.parseLong(contaDestino.getText());
    }
}
