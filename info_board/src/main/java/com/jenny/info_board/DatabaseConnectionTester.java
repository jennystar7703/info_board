import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DatabaseConnectionTester {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnectionTester(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DatabaseConnectionTester.class, args);
        DatabaseConnectionTester tester = context.getBean(DatabaseConnectionTester.class);
        tester.testConnection();
        context.close();
    }

    public void testConnection() {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
            System.out.println("Connection successful! Number of rows in 'users' table: " + count);
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
