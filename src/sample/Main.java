package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        //set icon of the application
        Image applicationIcon = new Image(getClass().getResourceAsStream("students.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
