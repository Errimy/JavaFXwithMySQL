module com.example.javafxwithmysql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxwithmysql to javafx.fxml;
    exports com.example.javafxwithmysql;
}