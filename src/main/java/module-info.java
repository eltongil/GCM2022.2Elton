module br.ufrn.imd.banco {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.ufrn.imd.banco to javafx.fxml;
    exports br.ufrn.imd.banco;
}