package br.ufrn.imd.banco.View.Abstratos;

import javafx.scene.text.Text;

public abstract class LabelAbstrato {
    protected static Text resposta = setText();

    protected static Text setText() {
        return null;
    }

    public static Text getInstance(){return resposta;}
    public static void setTexto(String texto){resposta.setText(texto);}
}
