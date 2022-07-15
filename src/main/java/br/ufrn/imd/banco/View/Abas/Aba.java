package br.ufrn.imd.banco.View.Abas;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import br.ufrn.imd.banco.View.Abstratos.EntradaNumerica;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public abstract class Aba {
    protected Tab estaAba;
    protected VBox coluna;
    protected Button botao;
    protected Text texto;
    protected TextField conta;
    protected TextField valor;

    public Aba(String TextoBotao, String TextoMensagem, String Nome, boolean temValor) {
        estaAba = new Tab(Nome);
        coluna = new VBox();

        conta = new TextField();
        conta.setPromptText("Número da conta");
        EntradaNumerica.setEntrada(conta);
        coluna.getChildren().add(conta);

        if (temValor) {
            valor = new TextField();
            valor.setPromptText("Valor financeiro");
            Pattern pattern = Pattern.compile("\\d*|\\d+\\.\\d*");
            TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
                return pattern.matcher(change.getControlNewText()).matches() ? change : null;
            });
            valor.setTextFormatter(formatter);
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
        return Long.parseLong(conta.getText());
    }

    public BigDecimal getValor() {
        return new BigDecimal(valor.getText());
    }
}
