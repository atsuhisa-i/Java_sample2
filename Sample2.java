import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample2 extends Application
{
  private Button bt;

  public static void main(String args[])
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    bt = new Button();

    bt.setText("購入");

    BorderPane bp = new BorderPane();

    bp.setCenter(bt);

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);
    
    stage.setTitle("サンプル");
    stage.show();
  }
}
