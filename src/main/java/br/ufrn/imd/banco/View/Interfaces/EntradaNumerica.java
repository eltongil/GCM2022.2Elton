package br.ufrn.imd.banco.View.Interfaces;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
public interface EntradaNumerica {
    private static TextField setText(){return null;}
    public static TextField getInstance(){return null;}
    public static void setEntrada(TextField numero){
        numero.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numero.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
