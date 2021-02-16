import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.image.*;

public class Sample7 extends Application
{
  private Label[] lb = new Label[3];
  private Image im;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    for(int i=0; i<lb.length; i++){
      lb[i] = new Label("車" + i + "はいかがですか？");
    }
    im = new Image(getClass().getResourceAsStream("時計.jpg"));

    lb[0].setGraphic(new ImageView(im));
    lb[1].setGraphic(new ImageView(im));
    lb[1].setContentDisplay(ContentDisplay.RIGHT);
    lb[2].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

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