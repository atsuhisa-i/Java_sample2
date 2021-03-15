import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.web.*;
import javafx.event.*;

public class Sample1 extends Application
{
  private TextField tf;
  private WebView wv;
  private Button bt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    tf = new TextField();
    wv = new WebView();
    bt = new Button("読込");

    BorderPane bp = new BorderPane();
    VBox vb = new VBox();

    vb.getChildren().addAll(bt, tf);

    bp.setTop(vb);
    bp.setCenter(wv);

    bt.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 600, 600);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      try{
        WebEngine we = wv.getEngine();
        we.load(tf.getText());
      }
      catch(Exception ex){
        ex.printStackTrace();
      }
    }
  }
}