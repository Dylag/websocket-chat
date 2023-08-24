package com.example.testjavafx.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ChatController {



    @FXML
    TextField tf_message;

    @FXML
    TextArea ta_chat;

    Thread messageReceiver;


    @FXML
    protected void sendMessage()
    {

    }
}