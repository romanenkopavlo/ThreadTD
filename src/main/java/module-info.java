module fr.btsciel.threadfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.threadfxml to javafx.fxml;
    exports fr.btsciel.threadfxml;
}