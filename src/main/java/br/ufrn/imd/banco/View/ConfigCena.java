package br.ufrn.imd.banco.View;

import br.ufrn.imd.banco.View.Criador.CriadorText;
import br.ufrn.imd.banco.View.Saldo.SaldoText;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;

public class ConfigCena {
    public static void configurar(Scene cena){
        cena.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                ObservableValue<? extends Number> observableValue,
                Number oldWidth,
                Number newWidth
            ){
                PainelDeAbas.getInstance().setPrefWidth(
                    newWidth.doubleValue()-10
                );
                CriadorText.getInstance().setWrappingWidth(
                    newWidth.doubleValue()-20
                );
                SaldoText.getInstance().setWrappingWidth(
                    newWidth.doubleValue()-10
                );
            }
        });
    }
}
