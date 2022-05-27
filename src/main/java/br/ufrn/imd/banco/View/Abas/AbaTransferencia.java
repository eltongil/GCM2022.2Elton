package br.ufrn.imd.banco.View.Abas;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.math.BigDecimal;

public class AbaTransferencia {

    private Tab aba;
    private VBox coluna;
    private TextField contaOrigem;
    private TextField contaDestino;
    private TextField valor;
    private Button botao;
    private Text texto;

    public AbaTransferencia() {
        aba = new Tab("Transferencia");
        coluna = new VBox();

        contaOrigem = new TextField();
        contaOrigem.setPromptText("Conta de Origem");
        EntradaNumerica.setEntrada(contaOrigem);
        coluna.getChildren().add(contaOrigem);

        contaDestino = new TextField();
        contaDestino.setPromptText("Conta de Destino");
        EntradaNumerica.setEntrada(contaOrigem);
        coluna.getChildren().add(contaDestino);

        valor = new TextField();
        valor.setPromptText("Valor financeiro");
        EntradaNumerica.setEntrada(valor);
        coluna.getChildren().add(valor);

        botao = new Button();
        botao.setText("Transferir");
        this.setBotao(botao);
        coluna.getChildren().add(botao);

        texto = new Text("");
        coluna.getChildren().add(texto);

        aba.setContent(coluna);
    }

    public Tab getAba() {
        return aba;
    }

    private void setBotao(Button botao) {
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                texto.setText(
                        ContaController.getInstance().transferencia(
                                getNumeroOrigem(),
                                getNumeroDestino(),
                                getValor()
                        ));
            }
        });
    }


    private Long getNumeroOrigem() {
        return Long.parseLong(contaOrigem.getText());
    }

    private Long getNumeroDestino() {
        return Long.parseLong(contaDestino.getText());
    }

    private BigDecimal getValor() {
        return new BigDecimal(valor.getText());
    }

}
