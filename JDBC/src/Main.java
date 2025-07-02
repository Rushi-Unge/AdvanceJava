import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/advjava";
        String user = "root";
        String password = "Rushi@123"; 
        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB!");
            conn.close();
         
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
