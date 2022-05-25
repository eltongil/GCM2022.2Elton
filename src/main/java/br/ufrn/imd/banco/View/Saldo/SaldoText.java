package br.ufrn.imd.banco.View.Saldo;

import javafx.scene.text.Text;

public class SaldoText{
    protected static Text singleton = setText();
    public static Text getInstance(){return singleton;}
    public static void setTexto(String texto){singleton.setText(texto);}
    protected static Text setText(){
        return new Text("Consulta de Saldo");
    }
}
