package org.example.SeleniumDb;
import java.sql.*;

public class TestDb {
    public static void connect() {
        Connection connection = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/PrvaBazaSQLLite.db";
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
    public static void createNewTable(){
        String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/javaFirstDB.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE usedCarTable(\n" +
                "id integer PRIMARY KEY,\n"+
                "car_model varchar(36),\n" +
                "car_year integer,\n" +
                "car_milage integer,\n" +
                "car_no_of_users integer);";
        try{
            Connection connection = DriverManager.getConnection(url);
            Statement statement= connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static class InsertRecords{
        private Connection connect(){
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/javaFirstDB.db";
            Connection connection=null;
            try{
                connection=DriverManager.getConnection(url);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return connection;
        }
        public void insert(String car_model, int car_year, int car_milage, int car_no_of_users) {
            String sql = "INSERT INTO usedCarTable(car_model, car_year, car_milage, car_no_of_users) VALUES(?,?,?,?)";
            try {
                Connection connection = this.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, car_model);
                preparedStatement.setInt(2, car_year);
                preparedStatement.setInt(3, car_milage);
                preparedStatement.setInt(4, car_no_of_users);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static class SelectRecords{
        private Connection connection(){
            String url = "jdbc:sqlite:C:/Users/Tane/Desktop/AQA/SQL/javaFirstDB.db";
            Connection connection = null;
            try{
                connection = DriverManager.getConnection(url);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return connection;
        }
        public void selectAll(){
            String sql ="SELECT * FROM usedCarTable";
            try{
                Connection connection=this.connection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                // loop through the result set
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id")+"\t" +
                            resultSet.getString("car_model")+"\t"+
                            resultSet.getInt("car_year")+"\t"+
                            resultSet.getInt("car_milage")+"\t"+
                            resultSet.getInt("car_no_of_users"));
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
//        connect();
//        createNewDatabase("javaFirstDB.db");
//        createNewTable();
//        InsertRecords rec = new InsertRecords();
//        rec.insert("Ford Mondeo", 2012, 145000, 2);
//        rec.insert("Renault Megane", 2010, 210000, 3);
//        rec.insert("Opel Astra", 2021, 57000, 1);
        SelectRecords sl = new SelectRecords();
        sl.selectAll();
    }
}
