import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample3 extends Application
{
  private Button[][] bt = new Button[6][3];

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    for(int i=0; i<bt.length; i++){
      for(int j=0; j<bt[i].length; j++){
        bt[i][j] = new Button(Integer.toString(i) + Integer.toString(j));
      }
    }

    GridPane gp = new GridPane();

    for(int i=0; i<bt.length; i++){
      for(int j=0; j<bt[i].length; j++){
        gp.add(bt[i][j], i, j);
      }
    }
    Scene sc = new Scene(gp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
}