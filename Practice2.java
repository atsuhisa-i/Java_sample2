import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.image.*;

public class Practice2 extends Application
{
  private Label lb;
  private CheckBox ch;
  private Image im;
  private ImageView iv;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("車です。");
    ch = new CheckBox("画像の表示");

    im = new Image(getClass().getResourceAsStream("時計.jpg"));
    iv = new ImageView(im);

    BorderPane bp = new BorderPane();

    bp.setCenter(lb);
    bp.setBottom(ch);

    ch.setOnAction(new SampleEventHandler());

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
        lb.setGraphic(iv);
      }
      else if(tmp.isSelected() == false){
        lb.setGraphic(null);
      }
    }
  }
}