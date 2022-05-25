package br.ufrn.imd.banco.View.Saque;

import javafx.scene.text.Text;

public class SaqueText {
    private static final Text singleton = setText();
    public static Text getInstance(){return singleton;}
    private static Text setText(){
        Text texto = new Text("Saque da conta.");
        return texto;
    }
    public static void setTexto(String texto){
        singleton.setText(texto);
    }
}
