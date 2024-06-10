import java.sql.*;
public class JDBC {
    String Url;
    String UserName;
    String Password;
    Connection con = null;
    public JDBC(String url, String userName, String password)  {
        Url = url;
        UserName = userName;
        Password = password;
        try {
            con = DriverManager.getConnection(Url, UserName, Password);
            System.out.println("MySql Connected Successfully");
        } catch (Exception e) {
            System.out.println("Not Connected");
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    public void ShowDb() {
        try {
            Statement stmt = con.createStatement();
            String command = "SHOW DATABASES;";
            ResultSet rs = stmt.executeQuery(command);
            int i = 1;
            while (rs.next()) {
                String name = rs.getString("database"); // Changed from getNString
                System.out.println(i++ + "." + name + " ");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void createDb(String dbName) {
        try {
            Statement stmt = con.createStatement();
            String command = "CREATE DATABASE " + dbName;
            stmt.executeUpdate(command);
            System.out.println("Database " + dbName + " created successfully");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void useDb(String dbName) {
        try {
            Statement stmt = con.createStatement();
            String command = "USE " + dbName;
            stmt.executeUpdate(command);
            System.out.println("Database " + dbName + " is Selected");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void deleteDb(String dbName) {
        try {
            Statement stmt = con.createStatement();
            String command = "DROP DATABASE " + dbName;
            stmt.executeUpdate(command);
            System.out.println(dbName + " Deleted Successfully");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void createTable(String tableName) {
        try {
            Statement stmt = con.createStatement();
            String command = "CREATE TABLE " + tableName + " (PersonID int,FirstName varchar(255),LastName varchar(255),Address varchar(255),City varchar(255))";
            stmt.executeUpdate(command);
            System.out.println(tableName + " created successfully");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void ShowAllTable(String dbName) {
        try {
            useDb(dbName);
            Statement stmt = con.createStatement();
            String command = "SHOW TABLES;";
            ResultSet rs = stmt.executeQuery(command);
            int i = 1;
            while (rs.next()) {
                String name = rs.getString("Tables_in_" + dbName); // Changed from getNString
                System.out.println(i++ + "." + name + " ");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}