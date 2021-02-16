import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class Sample5 extends Application
{
  private Label[] lb = new Label[3];

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    for(int i=0; i<lb.length; i++){
      lb[i] = new Label("車" + i + "はいかがですか？");
    }

    lb[0].setTextFill(Color.BLACK);
    lb[1].setTextFill(Color.BLUE);
    lb[2].setTextFill(Color.RED);

    BorderPane bp = new BorderPane();
    VBox vb = new VBox();

    for(int i=0; i<lb.length; i++){
      vb.getChildren().add(lb[i]);
    }
    bp.setCenter(vb);

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
}