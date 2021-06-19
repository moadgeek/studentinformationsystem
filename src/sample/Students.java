package sample;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Students {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private java.sql.Date birth_date;
    private int age;
    private String country;
    private String department;
    private String Faculty;
    private float gpa;
    private double StartingYear;
    private double GraduationYear;


    public Students() {
        super();
    }

    public Students(int id, String fname, String lname, String gender, Date birth_date, int age, String country, String department, String Faculty, float gpa, double startingYear, double graduationYear) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.birth_date = birth_date;
        this.age = age;
        this.country = country;
        this.department = department;
        this.Faculty = Faculty;
        this.gpa = gpa;
        this.StartingYear = startingYear;
        this.GraduationYear = graduationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public double getStartingYear() {
        return StartingYear;
    }

    public void setStartingYear(double startingYear) {
        this.StartingYear = startingYear;
    }

    public double getGraduationYear() {
        return GraduationYear;
    }

    public void setGraduationYear(double graduationYear) {
        this.GraduationYear = graduationYear;
    }
}
