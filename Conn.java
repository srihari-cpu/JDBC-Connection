import java.sql.*;

//set classpath=%classpath%;mysql-connector-j-8.4.0\;
class Conn {
  public static void main(String[] args) {

    // for the mysql
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/school";
    String user = "root";
    String password = "123456";

    try {

      // register the driver
      // Class.forName(driver);

      // create connection
      Connection conn1 = DriverManager.getConnection(url, user, password);

      // create statement
      Statement stmt = conn1.createStatement();

      // execute the query
      stmt.executeUpdate("insert into student values(5,'naveen')");

      // close the connection
      conn1.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
