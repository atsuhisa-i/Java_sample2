import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample5 extends Application
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

    sc.addEventHandler(MouseEvent.MOUSE_CLICKED, new SampleEventHandler());

    stage.setScene(sc);
    stage.show();
  }
  class SampleEventHandler implements EventHandler<MouseEvent>
  {
    public void handle(MouseEvent e)
    {
      lb.setText("ご購入ありがとうございます。");
    }
  }
}