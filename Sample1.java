import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample1 extends Application
{
  private Button[] bt = new Button[5];

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    bt[0] = new Button("Top");
    bt[1] = new Button("Bottom");
    bt[2] = new Button("Center");
    bt[3] = new Button("Left");
    bt[4] = new Button("Right");

    BorderPane bp = new BorderPane();

    bp.setTop(bt[0]);
    bp.setBottom(bt[1]);
    bp.setCenter(bt[2]);
    bp.setLeft(bt[3]);
    bp.setRight(bt[4]);

    for(int i=0; i<bt.length; i++){
      bp.setAlignment(bt[i], Pos.CENTER);
    }

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
}