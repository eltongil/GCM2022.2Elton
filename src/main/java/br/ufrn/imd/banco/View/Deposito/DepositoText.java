package br.ufrn.imd.banco.View.Deposito;

import javafx.scene.text.Text;

public class DepositoText {    
    protected static Text singleton = setText();
    public static Text getInstance(){return singleton;}
    public static void setTexto(String texto){singleton.setText(texto);}
    protected static Text setText(){
        Text texto = new Text();
        texto.setText("Deposito em conta");
        return texto;
    }
}
