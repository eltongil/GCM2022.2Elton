package br.ufrn.imd.banco.View.Deposito;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import javafx.scene.control.TextField;

public class DepositoValor {
    private static final TextField singleton = setEntrada();
    public static TextField getInstance(){return singleton;}
    private static TextField setEntrada(){
        TextField entrada = new TextField("Valor do deposito");
        EntradaNumerica.setEntrada(entrada);
        return entrada;
    }

}
