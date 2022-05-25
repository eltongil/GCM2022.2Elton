package br.ufrn.imd.banco.View.Abstratos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
public abstract class EntradaNumerica {
    private static TextField entrada = setNumero();
    private static TextField setNumero(){return null;}
    public static TextField getInstance(){return entrada;}
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
