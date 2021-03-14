import java.io.*;
import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample4C extends Application
{
  public static final String HOST = "localhost";
  public static final int PORT = 10000;

  private TextArea ta;
  private Button bt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    try{
      InetAddress ia = InetAddress.getLocalHost();

      ta = new TextArea();
      bt = new Button("接続");

      BorderPane bp = new BorderPane();

      bp.setCenter(ta);
      bp.setBottom(bt);

      bt.setOnAction(new SampleEventHandler());

      Scene sc = new Scene(bp, 300, 200);

      stage.setScene(sc);

      stage.setTitle("サンプル");
      stage.show();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      try{
        Socket sc = new Socket(HOST, PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String str = br.readLine();
        ta.setText(str);
        br.close();
        sc.close();
      }
      catch(Exception ex){
        ex.printStackTrace();
      }
    }
  }
}