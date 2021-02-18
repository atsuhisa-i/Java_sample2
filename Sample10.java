import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample10 extends Application
{
  private Label lb;
  private RadioButton rb1, rb2;
  private ToggleGroup tg;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");
    rb1 = new RadioButton("車");
    rb2 = new RadioButton("トラック");
    tg = new ToggleGroup();

    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);

    rb1.setSelected(true);

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

    hb.getChildren().add(rb1);
    hb.getChildren().add(rb2);
    hb.setAlignment(Pos.CENTER);

    bp.setTop(lb);
    bp.setCenter(hb);

    rb1.setOnAction(new SampleEventHandler());
    rb2.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      RadioButton tmp = (RadioButton) e.getSource();
      lb.setText(tmp.getText() + "を選びました。");
    }
  }
}