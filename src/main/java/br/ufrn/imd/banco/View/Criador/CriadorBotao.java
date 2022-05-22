package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.BotaoInterface;
import br.ufrn.imd.banco.View.OuvinteBotao;
import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CriadorBotao implements BotaoInterface {
    private static boolean ajustado = false;
    private static final Button Criador = new Button("Criar Conta");
    public static Button getInstance(){
        if(!ajustado){
            BotaoInterface.setButton();
        }
        return Criador;
    }
    @Override
    private static void setButton(){
        OuvinteBotao.setHandlers(Criador);
        Criador.setOnAction(new EventHandler<ActionEvent>()->{
          @Override
          public void handle(ActionEvent event){
                ContaController
            }
        } );
    }
    private void CriarConta(){

    }
}
