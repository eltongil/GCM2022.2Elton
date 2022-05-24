package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.BotaoAbstrato;
import br.ufrn.imd.banco.View.OuvinteBotao;
import br.ufrn.imd.banco.conta.ContaService;
import br.ufrn.imd.banco.exceptions.BadArgumentException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CriadorBotao extends BotaoAbstrato {
    protected static Button setButton(){
        Button botao = new Button("Criar Conta");
        OuvinteBotao.setHandlers(botao);
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CriarConta();
            }
        });
        return botao;
    }

    private static void CriarConta(){
        try {
            ContaService.getInstance().addConta(
                    EntradaCriador.getInstance().getText()
            );
        } catch (BadArgumentException e) {
            e.printStackTrace();
            CriadorLabel.setTexto(e.getMessage());
        }
    }
}
