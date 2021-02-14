import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Practice3 extends Application
{
  private Label lb1, lb2;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb1 = new Label("キーを押して下さい。");
    lb2 = new Label();

    BorderPane bp = new BorderPane();

    bp.setTop(lb1);
    bp.setBottom(lb2);

    Scene sc = new Scene(bp, 300, 200);

    sc.setOnKeyPressed(new SampleEventHandler());

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
  class SampleEventHandler implements EventHandler<KeyEvent>
  {
    public void handle(KeyEvent e)
    {
      String str;
      KeyCode k = e.getCode();
      str = k.toString();
      lb2.setText(str + "ですね。");
    }
  }
}
