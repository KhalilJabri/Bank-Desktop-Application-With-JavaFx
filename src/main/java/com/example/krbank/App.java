package com.example.krbank;

import com.example.krbank.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();

        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
