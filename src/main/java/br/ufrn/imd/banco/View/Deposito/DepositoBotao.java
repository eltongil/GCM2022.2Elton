package br.ufrn.imd.banco.View.Deposito;

import java.math.BigDecimal;

import br.ufrn.imd.banco.View.EscolherConta;
import br.ufrn.imd.banco.View.OuvinteBotao;
import br.ufrn.imd.banco.conta.ContaController;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DepositoBotao {
    private static final Button singleton = setButton();
    public static Button getInstance(){return singleton;}
    private static Button setButton(){
        Button botao = new Button("Depositar Valor.");     
        OuvinteBotao.setHandlers(botao);   
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                    try {
                        DepositoText.setTexto(
                            ContaController.deposito(
                                EscolherConta.getInstance().getValue(),
                                new BigDecimal(
                                    DepositoValor.getInstance().getText()
                                )
                            )
                        );
                    } catch (BadArgumentException e) {
                        DepositoText.setTexto(e.getMessage());
                        e.printStackTrace();
                    }
            }
        });
        return botao;
    }
}
