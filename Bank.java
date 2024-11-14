import java.sql.*;
import java.util.*;

public class Bank {
  public static void main(String[] args) {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/";
    String dbname = "bank";// database Name
    String user = "root";
    String password = "123456";
    String a="";

    // reading the values from the user
    Scanner sc = new Scanner(System.in);
    System.out.println("enter user name ");// name
    String uname = sc.next();
    System.out.println("enter password");// password
    String pass = sc.next();

    try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url + dbname, user, password);

      String qry = "select balance from bankbalance where username=? and password=?";
      PreparedStatement stmt = con.prepareStatement(qry);
      stmt.setString(1, uname);
      stmt.setString(2, pass);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        System.out.print("balance : " + rs.getDouble(1));
      } else {
        System.out.println("invalid details");
      }
      rs.close();
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}