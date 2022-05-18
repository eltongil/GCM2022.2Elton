module br.ufrn.imd.banco {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens br.ufrn.imd.banco to javafx.fxml;

    exports br.ufrn.imd.banco;
}