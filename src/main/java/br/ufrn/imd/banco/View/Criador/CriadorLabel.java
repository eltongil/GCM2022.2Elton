package br.ufrn.imd.banco.View.Criador;


import br.ufrn.imd.banco.View.Interfaces.LabelAbstrato;
import javafx.scene.text.Text;

public class CriadorLabel extends LabelAbstrato {
    protected static Text setText(){
        Text LabelCriador = new Text();
        LabelCriador.setText("Criação de conta");
        LabelCriador.setWrappingWidth(CriadorTab.getInstance().getTabPane().getWidth());
        return LabelCriador;
    }
}
