package com.example.krbank;

import com.example.krbank.Models.Model1;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model1.getInstance().getViewFactory().showLoginWindow();
    }
}
