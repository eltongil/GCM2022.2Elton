package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SaldoBotao{
    private static final Button singleton = setButton();
    public static Button getInstance(){return singleton;}
    protected static Button setButton(){
        Button botaoSaldo = new Button("Consultar");
        botaoSaldo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    SaldoText.setTexto(
                        ContaService.getInstance().consultarSaldo(
                            SaldoLayout.getConta()
                        )
                    );
                } catch (BadArgumentException e) {
                    SaldoText.setTexto(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        return botaoSaldo;
    }
}
