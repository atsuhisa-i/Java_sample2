import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Practice2 extends Application
{
  private Button bt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    bt = new Button("ようこそ。");

    BorderPane bp = new BorderPane();

    bp.setCenter(bt);

    Scene sc = new Scene(bp, 300, 200);

    sc.addEventHandler(MouseEvent.MOUSE_ENTERED, new SampleEventHandler());
    sc.addEventHandler(MouseEvent.MOUSE_EXITED, new SampleEventHandler());

    stage.setScene(sc);
    stage.setTitle("サンプル");
    stage.show();
  }
  class SampleEventHandler implements EventHandler<MouseEvent>
  {
    public void handle(MouseEvent e)
    {
      if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
        bt.setText("いらっしゃいませ。");
      }
      else if(e.getEventType() == MouseEvent.MOUSE_EXITED)
      {
        bt.setText("ようこそ。");
      }
    }
  }
}