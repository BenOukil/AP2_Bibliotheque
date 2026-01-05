module Oukil.APBANQUE_JAVAFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;

    opens Oukil.APBANQUE_JAVAFX to javafx.fxml;
    exports Oukil.APBANQUE_JAVAFX;
}
