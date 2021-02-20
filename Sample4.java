import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample4 extends Application
{
  private Button[] bt = new Button[10];
  private Label[] lb = new Label[5];

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    for(int i=0; i<bt.length; i++){
      bt[i] = new Button(Integer.toString(i));
    }
    for(int i=0; i<lb.length; i++){
      lb[i] = new Label(Integer.toString(i));
    }

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();
    VBox vb = new VBox();

    for(int i=0; i<bt.length; i++){
      hb.getChildren().add(bt[i]);
    }
    for(int i=0; i<lb.length; i++){
      vb.getChildren().add(lb[i]);
    }

    hb.setAlignment(Pos.CENTER);
    vb.setAlignment(Pos.CENTER);

    bp.setTop(hb);
    bp.setCenter(vb);

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
}