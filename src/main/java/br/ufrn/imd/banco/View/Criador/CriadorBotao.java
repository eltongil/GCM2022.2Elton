package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CriadorBotao{
    private static final Button singleton = setButton();
    public static Button getInstance(){return singleton;}
    protected static Button setButton(){
        Button botao = new Button("Criar Conta");
        //OuvinteBotao.setHandlers(botao);
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CriarConta();
            }
        });
        return botao;
    }

    private static void CriarConta(){
        ContaController.getInstance();
        CriadorText.setTexto(
            ContaController.adicionarConta(
                EntradaCriador.getInstance().getText()
            )
        );
    }
}
