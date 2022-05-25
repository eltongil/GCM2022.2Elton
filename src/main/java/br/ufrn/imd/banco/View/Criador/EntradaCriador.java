package br.ufrn.imd.banco.View.Criador;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import javafx.scene.control.TextField;

public class EntradaCriador extends EntradaNumerica {
    private static TextField setNumero(){
        TextField numero = new TextField();
        numero.setText("Novo numero");
        EntradaNumerica.setEntrada(numero);
        return numero;
    }
}
