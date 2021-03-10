package mybeans;
import java.util.*;
import java.io.*;
import java.sql.*;

public class CarDBBean implements Serializable
{
  private ArrayList<String> colname;
  private ArrayList<ArrayList> data;

  public CarDBBean()
  {
    try{
      String url = "jdbc:derby:cardb;create=true";
      String usr = "";
      String pw = "";

      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

      Connection cn = DriverManager.getConnection(url, usr, pw);

      DatabaseMetaData dm = cn.getMetaData();
      ResultSet tb = dm.getTables(null, null, "車表", null);

      Statement st = cn.createStatement();

      String qry1 = "CREATE TABLE 車表(番号 int, 名前 varchar(50))";
      String[] qry2 = {
        "INSERT INTO 車表 VALUES (2, '乗用車')",
        "INSERT INTO 車表 VALUES (3, 'オープンカー')",
        "INSERT INTO 車表 VALUES (4, 'トラック')"};
      String qry3 = "SELECT * FROM 車表";

      if(!tb.next()){
        st.executeUpdate(qry1);
        for(int i=0; i<qry2.length; i++){
          st.executeUpdate(qry2[i]);
        }
      }

      ResultSet rs = st.executeQuery(qry3);

      ResultSetMetaData rm = rs.getMetaData();
      int cnum = rm.getColumnCount();
      colname = new ArrayList<String>(cnum);

      for(int i=1; i<=cnum; i++){
        colname.add(rm.getColumnName(i).toString());
      }
      
      data = new ArrayList<ArrayList>();
      while(rs.next()){
        ArrayList<String> rowdata = new ArrayList<String>();
        for(int i=1; i<=cnum; i++){
          rowdata.add(rs.getObject(i).toString());
        }
        data.add(rowdata);
      }
      rs.close();
      st.close();
      cn.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  public ArrayList getData()
  {
    return data;
  }
  public ArrayList getColname()
  {
    return colname;
  }
}