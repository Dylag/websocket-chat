package com.example.testjavafx.sceneControllers;

import com.example.testjavafx.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RegistrationController {

    @FXML
    public TextArea ta_username;
    @FXML
    public PasswordField pf_password;

    @FXML
    public void registration() throws Exception {
        String username = ta_username.getText();
        String password = pf_password.getText();
        String body = String.format("""
                                        {
                                            "name":"%s",
                                            "password":"%s"
                                        }""",username,password);


        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/auth/reg"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .timeout(Duration.ofSeconds(5))
                .build();

        if(HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body().equals("OK")){
            User.name = username;
            Stage stage = (Stage) ta_username.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatScene.fxml"))));
        } else
            showError();

    }

    @FXML
    public void back() throws IOException
    {
        Stage stage = (Stage) ta_username.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WelcomeScene"))));
    }


    private void showError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sample Chat App");
        alert.setHeaderText("That username was already taken!");
        alert.showAndWait();
    }
}
