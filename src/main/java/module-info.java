module br.ufrn.imd.banco {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;

    opens br.ufrn.imd.banco to javafx.fxml;
    opens br.ufrn.imd.banco.conta to javafx.fxml;

    exports br.ufrn.imd.banco;
    exports br.ufrn.imd.banco.conta;
    exports br.ufrn.imd.banco.exceptions;
    exports br.ufrn.imd.banco.View;
    opens br.ufrn.imd.banco.View to javafx.fxml;
    exports br.ufrn.imd.banco.View.Abstratos;
    opens br.ufrn.imd.banco.View.Abstratos to javafx.fxml;
}