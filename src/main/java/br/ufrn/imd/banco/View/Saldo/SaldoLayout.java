package br.ufrn.imd.banco.View.Saldo;

import br.ufrn.imd.banco.View.Abstratos.ColunaAbstrata;
import javafx.scene.layout.VBox;

public class SaldoLayout extends ColunaAbstrata {
    protected static VBox setColuna(){
        VBox colunaSaldo = new VBox();
        colunaSaldo.getChildren().add(EntradaSaldo.getInstance());
        return colunaSaldo;
    }
}