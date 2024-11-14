import java.sql.*;
import java.util.*;

public class SqlEx {
  public static void main(String[] args) {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/";
    String dbname = "school";
    String user = "root";
    String password = "123456";
    Scanner sc = new Scanner(System.in);
    System.out.println("enter your rool number");
    int rno = sc.nextInt();
    System.out.println("enter your name");
    String name = sc.next();

    try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url + dbname, user, password);

      // Dynamic query prepration statement
      // ?,? positional parameters
      // Integer.parseInt() to convert string to int
      String qry = "insert into student values(?,?)";
      PreparedStatement stmt = con.prepareStatement(qry);
      stmt.setInt(1, rno);
      stmt.setString(2, name);
      stmt.executeUpdate();
      System.out.println("successfull");
      con.close();

    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
