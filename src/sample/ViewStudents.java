package sample;

import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.sql.*;
import java.util.ResourceBundle;

public class ViewStudents implements Initializable {
    @FXML
    private TableView<Students> table;
    @FXML
    private TableColumn<Students, Integer> id;
    @FXML
    private TableColumn<Students, String> fname;
    @FXML
    private TableColumn<Students, String> lname;
    @FXML
    private TableColumn<Students, String> gender;
    @FXML
    private TableColumn<Students, Date> birth_date;
    @FXML
    private TableColumn<Students, Integer> age;
    @FXML
    private TableColumn<Students, String> country;
    @FXML
    private TableColumn<Students, String> department;
    @FXML
    private TableColumn<Students, String> Faculty;
    @FXML
    private TableColumn<Students, Float> gpa;
    @FXML
    private TableColumn<Students, Double> StartingYear;
    @FXML
    private TableColumn<Students, Double> GraduationYear;


    public ObservableList<Students> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            String sql = "SELECT * FROM `sakila`.`students` WHERE 1";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                data.add(new Students(  rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
                    rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getFloat(10),
                    rs.getDouble(11), rs.getDouble(12)  ));
            }

            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<Students, Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Students, String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Students, String>("lname"));
        gender.setCellValueFactory(new PropertyValueFactory<Students, String>("gender"));
        birth_date.setCellValueFactory(new PropertyValueFactory<Students, Date>("birth_date"));
        age.setCellValueFactory(new PropertyValueFactory<Students, Integer>("age"));
        country.setCellValueFactory(new PropertyValueFactory<Students, String>("country"));
        department.setCellValueFactory(new PropertyValueFactory<Students, String>("department"));
        Faculty.setCellValueFactory(new PropertyValueFactory<Students, String>("Faculty"));
        gpa.setCellValueFactory(new PropertyValueFactory<Students, Float>("gpa"));
        StartingYear.setCellValueFactory(new PropertyValueFactory<Students, Double>("StartingYear"));
        GraduationYear.setCellValueFactory(new PropertyValueFactory<Students, Double>("GraduationYear"));

        table.setItems(data);
    }


}