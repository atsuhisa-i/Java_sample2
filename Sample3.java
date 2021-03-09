import java.sql.*;

public class Sample3
{
  public static void main(String args[])
  {
    if(args.length != 2){
      System.out.println("パラメータの数が違います。");
      System.exit(1);
    }
    
    try{
      String url = "jdbc:derby:cardb;create=true";
      String usr = "";
      String pw = "";

      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

      Connection cn = DriverManager.getConnection(url, usr, pw);

      Statement st = cn.createStatement();
      String qry1 = "INSERT INTO 車表 VALUES (" + args[0] + " , '" + args[1] + "')";
      String qry2 = "SELECT * FROM 車表";

      st.executeUpdate(qry1);
      ResultSet rs = st.executeQuery(qry2);

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