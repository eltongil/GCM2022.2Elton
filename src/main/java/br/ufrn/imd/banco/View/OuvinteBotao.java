package br.ufrn.imd.banco.View;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OuvinteBotao {
    public static void setHandlers(Button button){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            button.fire();
            mouseEvent.consume();
        });
    }
}
