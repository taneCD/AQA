package org.example.Evermed;
import org.example.SeleniumDb.TestDb;
import java.sql.*;
import static org.example.SeleniumDb.TestDb.connect;

public class EvermedDb {
    public static void EvermedDataBaseConnect() {
        Connection connection = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/EvermedDB.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/" + fileName;
        try {
            Connection connection = DriverManager.getConnection(url);
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/EvermedDB.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE EvermedConference(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "conference_name varchar(36));";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class InsertRecords {
        private Connection connect() {
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/EvermedDB.db";
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }

        public void insert(int id, String conference_name) {
            String sql = "INSERT INTO EvermedConference(id, conference_name) VALUES(?,?)";
            try {
                Connection connection = this.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, conference_name);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class SelectRecords {
        private Connection connection() {
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/EvermedDB.db";
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }

        public void selectAll() {
            String sql = "SELECT * FROM EvermedConference";
            try {
                Connection connection = this.connection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                // loop through the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + "\t" +
                            resultSet.getString("conference_name"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //    public static void main(String[] args) {
    public void aktivacija() throws InterruptedException {
        EvermedDataBaseConnect();
        createNewDatabase("EvermedDB.db");
        Thread.sleep(2000);
        createNewTable();
    }
}

