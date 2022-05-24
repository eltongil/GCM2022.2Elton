package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Interfaces.EntradaNumerica;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class EntradaCriador implements EntradaNumerica {
    private static final TextField entradaNumero = setNumero();
    private static TextField setNumero(){
        TextField numero = new TextField();
        numero.setText("Novo numero");
        EntradaNumerica.setEntrada(numero);
        return numero;
    }
    public static TextField getInstance(){return entradaNumero;}
}
