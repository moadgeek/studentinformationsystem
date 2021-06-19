package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class InsertStudents {
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

    public void insertData(javafx.event.ActionEvent e) throws IOException {

        LocalDate dateOfBirth = birth_date.getValue();
        String TextfirstName = fname.getText();
        String TextlastName = lname.getText();
        String TextGender = gender.getText();
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

        int status = DBinfo.add(std);

        if(status>0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Insertion");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record saved successfully!");
            alert.showAndWait();

            System.out.println("Record saved successfully!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Insertion");
            alert.setHeaderText("ERROR Dialog");
            alert.setContentText("Sorry, unable to save record.");
            alert.showAndWait();

            System.out.println("Sorry, unable to save record.");
        }

    }


}
