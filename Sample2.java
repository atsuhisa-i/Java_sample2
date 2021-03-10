import java.sql.*;

public class Sample2
{
  public static void main(String[] args)
  {
    try{
      String url = "jdbc:derby:cardb;create=true";
      String usr = "";
      String pw = "";

      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

      Connection cn = DriverManager.getConnection(url, usr, pw);

      Statement st = cn.createStatement();
      String qry = "SELECT * FROM 車表 WHERE 番号>=3";

      ResultSet rs = st.executeQuery(qry);

      ResultSetMetaData rm = rs.getMetaData();
      int cnum = rm.getColumnCount();
      while(rs.next()){
        for(int i=1; i<=cnum; i++){
          System.out.print(rm.getColumnName(i) + ":" + 
            rs.getObject(i) + "  ");
        }
        System.out.println("");
      }

      rs.close();
      st.close();
      cn.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}