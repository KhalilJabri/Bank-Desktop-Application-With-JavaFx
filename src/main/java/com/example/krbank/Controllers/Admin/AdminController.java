package com.example.krbank.Controllers.Admin;

import com.example.krbank.Models.Model1;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model1.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case CLIENTS -> admin_parent.setCenter(Model1.getInstance().getViewFactory().getClientsView());
                case DEPOSIT -> admin_parent.setCenter(Model1.getInstance().getViewFactory().getDepositView());
                default -> admin_parent.setCenter(Model1.getInstance().getViewFactory().getCreateClientView());
            }
        });
    }
}
