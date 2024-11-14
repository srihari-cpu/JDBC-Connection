import java.lang.Thread.State;
import java.sql.*;

public class ConnOR {
  public static void main(String[] args) {

    // String driver = "Oracle.jdbc.driver.OracleDriver";
    // jdbc:oracle:thin:username/password@localhost:1521:XE
    // String url = "jdbc:oracle:thin:SYSTEM/123456@localhost:1521:XE";
    // String user = "SYSTEM";
    // String password = "123456";

    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1520/XE";
    String user = "SYSTEM";
    String password = "123456";
    try {
      Class.forName(driver);
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement stmt = conn.createStatement();
      stmt.executeUpdate("insert into student values(1,'srihari')");
      conn.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
