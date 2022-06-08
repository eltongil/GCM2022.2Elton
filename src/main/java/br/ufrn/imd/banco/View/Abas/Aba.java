package br.ufrn.imd.banco.View.Abas;

import java.math.BigDecimal;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public abstract class Aba {
    protected Tab estaAba;
    protected VBox coluna;
    protected Button botao;
    protected Text texto;
    protected TextField contaOrigem;
    protected TextField contaDestino;
    protected TextField valor;

    public Aba(String TextoBotao, String TextoMensagem, String Nome, boolean temValor, boolean temDestino) {
        estaAba = new Tab(Nome);
        coluna = new VBox();

        contaOrigem = new TextField();
        contaOrigem.setPromptText("Número da conta");
        EntradaNumerica.setEntrada(contaOrigem);
        coluna.getChildren().add(contaOrigem);

        if (temDestino) {
            contaDestino = new TextField();
            contaOrigem.setPromptText("Número da conta de Origem");
            contaDestino.setPromptText("Número da conta de Destino");
            EntradaNumerica.setEntrada(contaDestino);
            coluna.getChildren().add(contaDestino);
        }
        if (temValor) {
            valor = new TextField();
            valor.setPromptText("Valor financeiro");
            EntradaNumerica.setEntrada(valor);
            coluna.getChildren().addAll(valor);
        }

        botao = new Button(TextoBotao);
        setBotao(botao);
        coluna.getChildren().add(botao);

        texto = new Text(TextoMensagem);
        coluna.getChildren().add(texto);

        estaAba.setContent(coluna);
    }

    abstract protected void setBotao(Button botao);

    public Tab getAba() {
        return estaAba;
    }

    public Long getNumero() {
        return Long.parseLong(contaOrigem.getText());
    }

    public BigDecimal getValor() {
        return new BigDecimal(valor.getText());
    }
}
