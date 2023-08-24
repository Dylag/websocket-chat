package com.example.testjavafx.sceneControllers;

import com.example.testjavafx.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class LoginController {

    @FXML
    TextField tf_username;

    @FXML
    PasswordField pf_password;

    @FXML
    public void auth() throws IOException, InterruptedException {
        String username = tf_username.getText();
        String password = pf_password.getText();

        String body = String.format("""
                                        {
                                            "name":"%s",
                                            "password":"%s"
                                        }""",username,password);

        HttpRequest rq = HttpRequest.newBuilder(URI.create("http://localhost:8080/auth/login"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .timeout(Duration.ofSeconds(5))
                .build();

        String resp = HttpClient.newHttpClient().send(rq, HttpResponse.BodyHandlers.ofString()).body();
        if(resp.equals("OK")){
            User.name = username;
            Stage stage = (Stage) tf_username.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatScene.fxml"))));
        } else
            showError(resp);
    }

    public void back() throws IOException
    {
        Stage stage = (Stage) tf_username.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"))));
    }

    private void showError(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sample Chat App");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
