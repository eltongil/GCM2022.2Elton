package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.conta.ContaModel;
import br.ufrn.imd.banco.conta.ContaRepository;
import javafx.scene.control.ComboBox;

public class EntradaSaldo{
    private static ComboBox<Long> ComboContas = setCombo();
    private static ComboBox<Long> setCombo(){
        ComboBox<Long> comboBox = new ComboBox<Long>();
        for (ContaModel conta : ContaRepository.getInstance().getLista()){
            comboBox.getItems().add(conta.getNumero());
        }
        return comboBox;
    }
    public static ComboBox<Long> getInstance(){return ComboContas;}
}
