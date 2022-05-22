package br.ufrn.imd.banco.View.Criador;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class EntradaCriador {
    private static final TextField entradaNumero = new TextField("Nova conta");
    public static TextField getInstance(){
        try {
            entradaNumero.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        entradaNumero.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return entradaNumero;
    }
}
