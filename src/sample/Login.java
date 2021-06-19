package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Login {
    @FXML
    Label dbConlb;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label check;

    public void statusDB(ActionEvent e) throws IOException, SQLException{
        if(!AdminsDB.getConnection().isClosed()){
            dbConlb.setText("Connected");
        }
        else{
            dbConlb.setText("Not Connected");
        }
    }

    public void enterCP(ActionEvent e) throws IOException, SQLException {
        List<Admins> list = AdminsDB.getAdmins(); // From MySQL

        Map<String, String> map = new HashMap<String,String>();

        for(Admins a:list){
            map.put(a.getUsername(), a.getPassword());
        }

        if(map.containsKey(username.getText())){
            String val2 = map.get(username.getText());
            if(val2.equals((password.getText()))){

                check.setText("Success");

                AdminsDB.getConnection();

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
                Scene scene = new Scene(root, 700,500);
                primaryStage.setScene(scene);

                //set icon of the application
                Image applicationIcon = new Image(getClass().getResourceAsStream("students.png"));
                primaryStage.getIcons().add(applicationIcon);


                primaryStage.setTitle("SecondInterface");
                primaryStage.showAndWait();

            }else {
                check.setText("Failed, Try again!");
            }


        }else {
            check.setText("Failed, Try again!");
        }

    }


}
