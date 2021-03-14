import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample3 extends Application
{
  private Label lb1, lb2, lb3;
  private TextField tf1, tf2, tf3;
  private Button bt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    try{
      InetAddress ia = InetAddress.getLocalHost();

      lb1 = new Label("入力して下さい。");
      lb2 = new Label("ホスト名");
      lb3 = new Label("IPアドレス");
      tf1 = new TextField();
      tf2 = new TextField();
      tf3 = new TextField();
      bt = new Button("検索");

      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

      vb.getChildren().add(lb1);
      vb.getChildren().add(tf1);
      vb.getChildren().add(lb2);
      vb.getChildren().add(tf2);
      vb.getChildren().add(lb3);
      vb.getChildren().add(tf3);

      bp.setCenter(vb);
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
        InetAddress ia = InetAddress.getByName(tf1.getText());
        tf2.setText(ia.getHostName());
        tf3.setText(ia.getHostAddress());
      }
      catch(Exception ex){
        ex.printStackTrace();
      }
    }
  }
}