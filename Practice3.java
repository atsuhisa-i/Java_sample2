import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class Practice3 extends Application
{
  private Label lb;
  private RadioButton rb1, rb2, rb3;
  private ToggleGroup tg;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("Hello!");
    rb1 = new RadioButton("普通");
    rb2 = new RadioButton("太字");
    rb3 = new RadioButton("イタリック");
    tg = new ToggleGroup();

    rb1.setToggleGroup(tg);
    rb2.setToggleGroup(tg);
    rb3.setToggleGroup(tg);

    rb1.setSelected(true);

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

    hb.getChildren().add(rb1);
    hb.getChildren().add(rb2);
    hb.getChildren().add(rb3);
    hb.setAlignment(Pos.CENTER);

    bp.setTop(lb);
    bp.setCenter(hb);

    rb1.setOnAction(new SampleEventHandler());
    rb2.setOnAction(new SampleEventHandler());
    rb3.setOnAction(new SampleEventHandler());

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
      if(tmp == rb1)
        lb.setFont(Font.font("Serif", 12));
      
      else if(tmp == rb2)
        lb.setFont(Font.font("Serif", FontWeight.BOLD, 12));
      
      else if(tmp == rb3)
        lb.setFont(Font.font("Serif", FontPosture.ITALIC, 12));
    }
  }
}
