package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AbaSaldo extends Aba {

    public AbaSaldo() {
        super("Consultar", "Saldo disponível", "Saldo", false, false);
    }

    @Override
    protected void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    texto.setText(
                            ContaService.getInstance().consultarSaldo(
                                    getNumero()));
                } catch (BadArgumentException e) {
                    texto.setText(e.getMessage());
                    e.printStackTrace();
                }
            }
        });

    }

}
