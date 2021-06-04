package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class app extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button bOK = new Button("OK");
        Scene scene = new Scene(bOK, 200, 250);
        primaryStage.setTitle("MyJavaFX");  // Set the stage title
        primaryStage.setScene(scene);  // Place the scene in the stage
        primaryStage.show();  // Display the stage
    }
}
