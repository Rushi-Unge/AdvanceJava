
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

    public void createDatabase() {
        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String password = "Rushi@123";
        try {

            Connection conn = DriverManager.getConnection(url, userName, password);

            // create Statement
            Statement stm = conn.createStatement();
            String query = "create database StudentsData";
            stm.execute(query);
            System.out.println("Database Created Successfully!");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    public void createTable() {
        String url = "jdbc:mysql://localhost:3306/StudentsData";
        String userName = "root";
        String password = "Rushi@123";
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);

            Statement stm = conn.createStatement();
            String query = "CREATE TABLE STUDENTS(sid INT(3),sname VARCHAR(50),sclass INT(3))";
            stm.execute(query);
            System.out.println("Table Created Successfully!");
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createData() {
        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String db = "StudentsData";
        String password = "Rushi@123";
        try {
            Connection conn = DriverManager.getConnection(url + db, userName, password);
            //  Statement stm = conn.createStatement();  
            //  String query = "INSERT INTO STUDENTS VALUES(1,'Rushi',12)";  works 

            String query = "INSERT INTO STUDENTS (sid,sname,sclass) VALUES(?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, 4);
            pstm.setString(2, "Jay");
            pstm.setInt(3, 9);
            pstm.execute();   //pstm.executeUpdate() both the methods insert the data.
            System.out.println("Data Inserted Successfully!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readData() {

        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String db = "StudentsData";
        String password = "Rushi@123";

        try {
            Connection conn = DriverManager.getConnection(url + db, userName, password);

            Statement stm = conn.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("id = " + rs.getInt(1));
                System.out.println("name = " + rs.getString(2));
                System.out.println("class = " + rs.getInt(3));
            }
            System.out.println("Read Successfully ");
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String db = "StudentsData";
        String password = "Rushi@123";

        try {
          Connection conn = DriverManager.getConnection(url+db, userName, password);
          String query  ="UPDATE STUDENTS SET sid = ? where sname = ?";

          PreparedStatement pstm = conn.prepareStatement(query);
          pstm.setInt(1, 5);
          pstm.setString(2,"Jay");
          pstm.execute();
          System.out.println("Data Updated Successfully");
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
          
        }
    }

    public void deleteData() {
       String url = "jdbc:mysql://localhost:3306/";
       String userName = "root";
       String db = "StudentsData";
       String password = "Rushi@123";

       try {
        Connection conn = DriverManager.getConnection(url+db,userName,password);
        String query ="DELETE FROM STUDENTS WHERE sid = ?";
        PreparedStatement pstm =conn.prepareStatement(query);
        pstm.setInt(1,3);
        pstm.execute();
        System.out.println("Data Deleted Successfully");
        conn.close();

       } catch (SQLException e) {
        e.printStackTrace();
       }
    }


}
