import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.*;

// table names : USERS, LOGIN_CREDENTIALS
public class database {
  public static void main(String[] args) throws SQLException {
    Properties props = new Properties();
    try (InputStream in = new FileInputStream("./database.properties")) {
      props.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String url = props.getProperty("url");
    Properties connProps = new Properties();
    connProps.setProperty("user", props.getProperty("username"));
    connProps.setProperty("password", props.getProperty("password"));
    connProps.setProperty("internal_logon", "SYSDBA");

    try (Connection conn = DriverManager.getConnection(url, connProps)) {
      System.out.println("Connected to database");
    } catch (SQLException e) {
      System.err.println("Failed to connect to database");
      e.printStackTrace();
    }
  }
}
