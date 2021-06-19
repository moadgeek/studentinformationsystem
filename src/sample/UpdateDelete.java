package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class UpdateDelete {
    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField gender;
    @FXML
    private DatePicker birth_date;
    @FXML
    private TextField age;
    @FXML
    private TextField country;
    @FXML
    private TextField department;
    @FXML
    private TextField Faculty;
    @FXML
    private TextField gpa;
    @FXML
    private TextField StartingYear;
    @FXML
    private TextField GraduationYear;

    public void getStudentsById(ActionEvent e) throws IOException, ParseException {
        String sid = id.getText();
        int id = Integer.parseInt(sid);

        Students std = DBinfo.getStudentsId(id);

        fname.setText(std.getFname());
        lname.setText(std.getLname());
        gender.setText(std.getGender());
        birth_date.setValue(std.getBirth_date().toLocalDate());
        age.setText(Integer.toString(std.getAge()));
        country.setText(std.getCountry());
        department.setText(std.getDepartment());
        Faculty.setText(std.getFaculty());
        gpa.setText(Float.toString(std.getGpa()));
        StartingYear.setText(Double.toString(std.getStartingYear()));
        GraduationYear.setText(Double.toString(std.getGraduationYear()));


    }

    public void update(ActionEvent e) throws IOException, ParseException{
        String sid = id.getText();
        int id = Integer.parseInt(sid);

        String TextfirstName = fname.getText();
        String TextlastName = lname.getText();
        String TextGender = gender.getText();
        LocalDate dateOfBirth = birth_date.getValue();
        Integer TextAge = Integer.parseInt(age.getText());
        String TextCountry = country.getText();
        String TextDepartment = department.getText();
        String Textfaculty = Faculty.getText();
        Float TextGpa = Float.parseFloat(gpa.getText());
        Double TextStartingyear = Double.parseDouble(StartingYear.getText());
        Double TextGraduationyear = Double.parseDouble(GraduationYear.getText());



        Students std = new Students();

        std.setFname(TextfirstName);
        std.setLname(TextlastName);
        std.setGender(TextGender);
        std.setBirth_date(Date.valueOf(dateOfBirth));
        std.setAge(TextAge);
        std.setCountry(TextCountry);
        std.setDepartment(TextDepartment);
        std.setFaculty(Textfaculty);
        std.setGpa(TextGpa);
        std.setStartingYear(TextStartingyear);
        std.setGraduationYear(TextGraduationyear);

        std.setId(Integer.parseInt(sid));

        DBinfo.update(std);
        // When I click on Update, connected but nothing executes after

        int status = DBinfo.update(std);


        if(status>0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Update");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record updated successfully!");
            alert.showAndWait();

            System.out.println("Record updated successfully!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Update");
            alert.setHeaderText("ERROR Dialog");
            alert.setContentText("Sorry, unable to update record.");
            alert.showAndWait();

            System.out.println("Sorry, unable to update record.");
        }
    }


    public void delete(ActionEvent e) throws IOException, ParseException{
    String sid = id.getText();
    int id = Integer.parseInt(sid);


    int status = DBinfo.delete(id);
    if(status>0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Data delete");
        alert.setHeaderText("Information Dialog");
        alert.setContentText("Record deleted successfully!");
        alert.showAndWait();

        System.out.println("Record deleted successfully!");

    }else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Data Delete");
        alert.setHeaderText("ERROR Dialog");
        alert.setContentText("Sorry, unable to delete record.");
        alert.showAndWait();

        System.out.println("Sorry, unable to delete record.");
    }





    }
}
