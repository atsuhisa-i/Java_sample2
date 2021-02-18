import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample9 extends Application
{
  private Label lb;
  private CheckBox ch1, ch2;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");
    ch1 = new CheckBox("車");
    ch2 = new CheckBox("トラック");

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

    hb.getChildren().add(ch1);
    hb.getChildren().add(ch2);
    hb.setAlignment(Pos.CENTER);

    bp.setTop(lb);
    bp.setCenter(hb);

    ch1.setOnAction(new SampleEventHandler());
    ch2.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      CheckBox tmp = (CheckBox) e.getSource();
      if(tmp.isSelected() == true){
        lb.setText(tmp.getText() + "を選びました。");
      }
      else if(tmp.isSelected() == false){
        lb.setText(tmp.getText() + "をやめました。");
      }
    }
  }
}