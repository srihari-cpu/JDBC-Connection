import java.sql.*;

//set classpath=%classpath%;mysql-connector-j-8.4.0;
class Show {
  public static void main(String[] args) {

    // for the mysql
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/school";
    String user = "root";
    String password = "123456";

    try {

      Class.forName(driver);
      Connection conn1 = DriverManager.getConnection(url, user, password);

      // static statement
      Statement stmt = conn1.createStatement();

      ResultSet rs = stmt.executeQuery("select * from student;");
      while (rs.next()) {
        System.out.print("rno : " + rs.getInt("rno") + "\t" + "name : " + rs.getString("name"));
        System.out.println();

      }
      rs.close();
      conn1.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
