module com.example.krbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.example.krbank to javafx.fxml;
    exports com.example.krbank;
    exports com.example.krbank.Controllers;
    exports com.example.krbank.Controllers.Admin;
    exports com.example.krbank.Controllers.Client;
    exports com.example.krbank.Models;
    exports com.example.krbank.Views;
}