package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlPanel {



    public void viewStudents(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewStudents.fxml"));
        Scene scene = new Scene(root, 912,400);
        primaryStage.setScene(scene);

        //set icon of the application
        Image applicationIcon = new Image(getClass().getResourceAsStream("students.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.show();

    }

    public void insertStudents(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("InsertStudents.fxml"));
        Scene scene = new Scene(root, 812,600);
        primaryStage.setScene(scene);

        //set icon of the application
        Image applicationIcon = new Image(getClass().getResourceAsStream("students.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.show();

    }

    public void UpdateDelete(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
        Scene scene = new Scene(root, 812,600);
        primaryStage.setScene(scene);

        //set icon of the application
        Image applicationIcon = new Image(getClass().getResourceAsStream("students.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.show();
    }

}
