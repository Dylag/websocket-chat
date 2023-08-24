module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.net.http;
    //requires validatorfx;

    opens com.example.testjavafx to javafx.fxml;
    exports com.example.testjavafx;
    exports com.example.testjavafx.sceneControllers;
    opens com.example.testjavafx.sceneControllers to javafx.fxml;
    exports com.example.testjavafx.startUps;
    opens com.example.testjavafx.startUps to javafx.fxml;
}