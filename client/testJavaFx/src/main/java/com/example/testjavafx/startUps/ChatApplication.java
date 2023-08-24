package com.example.testjavafx.startUps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("WelcomeScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sample chat app");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            System.out.println("closing...");
            javafx.application.Platform.exit();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}