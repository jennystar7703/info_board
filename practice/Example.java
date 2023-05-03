import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("database.properties")) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties connProps = new Properties();
            connProps.setProperty("user", username);
            connProps.setProperty("password", password);
            connProps.setProperty("internal_logon", "SYSDBA");
            Connection conn = DriverManager.getConnection(url, connProps);
            System.out.println("Connected to database!");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC driver not found");
            e.printStackTrace();
        }
    }
}
