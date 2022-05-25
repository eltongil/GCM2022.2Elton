package br.ufrn.imd.banco.View.Saque;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import javafx.scene.control.TextField;

public class SaqueValor {
    private static final TextField singleton = setEntrada();
    public static TextField getInstance(){return singleton;}
    private static TextField setEntrada(){
        TextField entrada =  new TextField("Valor do saque.");
        EntradaNumerica.setEntrada(entrada);
        return entrada;
    }

}
