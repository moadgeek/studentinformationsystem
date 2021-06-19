package sample;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DBinfo {

    public static Connection getConnection() {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3300/sakila", "root", "admin");
            System.out.println("connected");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static int add(Students std){
        int st=0;
        try{
            String sql = "INSERT INTO `sakila`.`students` (`fname`, `lname`, `gender`, `birth_date`, `age`, `country`, `department`, `Faculty`, `gpa`, `StartingYear`, `GraduationYear`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, std.getFname());
            preparedStatement.setString(2, std.getLname());
            preparedStatement.setString(3, std.getGender());
            preparedStatement.setDate(4, std.getBirth_date());
            preparedStatement.setInt(5, std.getAge());
            preparedStatement.setString(6, std.getCountry());
            preparedStatement.setString(7, std.getDepartment());
            preparedStatement.setString(8, std.getFaculty());
            preparedStatement.setFloat(9, std.getGpa());
            preparedStatement.setDouble(10, std.getStartingYear());
            preparedStatement.setDouble(11, std.getGraduationYear());

            st = preparedStatement.executeUpdate();

            con.close();

        }catch (SQLException e){
        e.printStackTrace();
        }
        return st;
    }

    public static int update(Students std){
        int st=0;
        try{
            String sql= "UPDATE `sakila`.`students` SET `fname`=?, `lname`=?, `gender`=?, `birth_date`=?, `age`=?, `country`=?, `department`=?, `Faculty`=?, `gpa`=?, `StartingYear`=?, `GraduationYear`=? WHERE `id`= ?;";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, std.getFname());
            preparedStatement.setString(2, std.getLname());
            preparedStatement.setString(3, std.getGender());
            preparedStatement.setDate(4, std.getBirth_date());
            preparedStatement.setInt(5, std.getAge());
            preparedStatement.setString(6, std.getCountry());
            preparedStatement.setString(7, std.getDepartment());
            preparedStatement.setString(8, std.getFaculty());
            preparedStatement.setFloat(9, std.getGpa());
            preparedStatement.setDouble(10, std.getStartingYear());
            preparedStatement.setDouble(11, std.getGraduationYear());
            preparedStatement.setInt(12, std.getId());
            System.out.println(preparedStatement);
            st = preparedStatement.executeUpdate();
            //System.out.println(preparedStatement.executeUpdate(sql2));

            con.close();

        }catch (SQLException e){
        e.printStackTrace();
        }
        return st;
    }

    public static int delete(int id){
        int st=0;
        try{
            String sql="DELETE FROM `sakila`.`students` WHERE id=?";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            st = preparedStatement.executeUpdate();

            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return st;
    }

    public static Students getStudentsId(int id){
        Students std = new Students();
        try{
            String sql = "SELECT * FROM `sakila`.`students` WHERE id=?";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                std.setId(resultSet.getInt(1));
                std.setFname(resultSet.getString(2));
                std.setLname(resultSet.getString(3));
                std.setGender(resultSet.getString(4));
                std.setBirth_date(resultSet.getDate(5));
                std.setAge(resultSet.getInt(6));
                std.setCountry(resultSet.getString(7));
                std.setDepartment(resultSet.getString(8));
                std.setFaculty(resultSet.getString(9));
                std.setGpa(resultSet.getFloat(10));
                std.setStartingYear(resultSet.getDouble(11));
                std.setGraduationYear(resultSet.getDouble(12));

            }
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return std;
    }

    public static List<Students> getStudents(){
        List<Students> list = new ArrayList<Students>();
        try{
            String sql = "SELECT * FROM `sakila`.`students` WHERE 1";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Students std = new Students();

                std.setId(resultSet.getInt(1));
                std.setFname(resultSet.getString(2));
                std.setLname(resultSet.getString(3));
                std.setGender(resultSet.getString(4));
                std.setBirth_date(resultSet.getDate(5));
                std.setAge(resultSet.getInt(6));
                std.setCountry(resultSet.getString(7));
                std.setDepartment(resultSet.getString(8));
                std.setFaculty(resultSet.getString(9));
                std.setGpa(resultSet.getFloat(10));
                std.setStartingYear(resultSet.getDouble(11));
                std.setGraduationYear(resultSet.getDouble(12));
                list.add(std);

            }
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }



}