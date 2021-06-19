package sample;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminsDB {

    static Connection con = null;

    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3300/sakila", "root", "admin");
            System.out.println("connected");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    return con;
    }

    public static List<Admins> getAdmins(){
        List<Admins> list = new ArrayList<Admins>();

        try{
            String sql = "SELECT * FROM sakila.users WHERE 1";
            Connection con = AdminsDB.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Admins adm = new Admins();

                adm.setId(resultSet.getInt(1));
                adm.setUsername(resultSet.getString(2));
                adm.setPassword(resultSet.getString(3));

                list.add(adm);
            }

            con.close();

        }catch (SQLException e){e.printStackTrace();}

        return list;
    }

}