import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.image.*;

public class Sample8 extends Application
{
  private Label lb;
  private Button bt;
  private Image im;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");
    bt = new Button("購入");

    im = new Image(getClass().getResourceAsStream("時計.jpg"));
    bt.setGraphic(new ImageView(im));

    BorderPane bp = new BorderPane();

    bp.setTop(lb);
    bp.setCenter(bt);

    bt.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      lb.setText("ご購入ありがとうございます。");
      bt.setDisable(true);
    }
  }
}