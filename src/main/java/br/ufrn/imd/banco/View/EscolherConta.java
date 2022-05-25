package br.ufrn.imd.banco.View;

import br.ufrn.imd.banco.conta.ContaRepository;
import javafx.scene.control.ComboBox;

public class EscolherConta {
    private static ComboBox<Long> singleton = setContas();
    public static ComboBox<Long> getInstance(){return singleton;}
    private static ComboBox<Long> setContas(){
        ComboBox<Long> nova = new ComboBox<>();
        for(Long numero : ContaRepository.getInstance().getNumeros()){
            nova.getItems().add(numero);
        }
        return nova;
    }
    public static void atualizar(){
        singleton = setContas();
    }
}
