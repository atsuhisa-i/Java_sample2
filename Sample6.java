import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample6 extends Application
{
  private Label lb;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");

    BorderPane bp = new BorderPane();

    bp.setTop(lb);

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
        lb.setText("いらっしゃいませ。");
      }
      else if(e.getEventType() == MouseEvent.MOUSE_EXITED)
      {
        lb.setText("ようこそ。");
      }
    }
  }
}