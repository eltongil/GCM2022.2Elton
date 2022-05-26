package br.ufrn.imd.banco.View;

import javafx.scene.control.TextField;

public class EscolherConta {
    private TextField conta;
    public EscolherConta(){
        conta = new TextField("Numero da conta");
    }
    public TextField getConta(){return conta;}
}
