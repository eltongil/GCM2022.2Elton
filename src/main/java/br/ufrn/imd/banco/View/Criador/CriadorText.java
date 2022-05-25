package br.ufrn.imd.banco.View.Criador;

import javafx.scene.text.Text;

public class CriadorText{
    protected static Text singleton = setText();
    public static Text getInstance(){return singleton;}
    public static void setTexto(String texto){singleton.setText(texto);}
    protected static Text setText(){
        Text LabelCriador = new Text();
        LabelCriador.setText("Criação de conta");
        return LabelCriador;
    }
}