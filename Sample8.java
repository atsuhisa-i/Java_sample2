import java.io.*;
import java.util.regex.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample8 extends Application
{
  private Label lb1, lb2, lb3;
  private TextArea ta;
  private TextField tf1, tf2;
  private Button bt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb1 = new Label("入力して下さい。");
    lb2 = new Label("置換前");
    lb3 = new Label("置換後");
    ta = new TextArea();

    bt = new Button("置換");
    tf1 = new TextField();
    tf2 = new TextField();

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

    hb.getChildren().add(lb2);
    hb.getChildren().add(tf1);
    hb.getChildren().add(lb3);
    hb.getChildren().add(tf2);
    hb.getChildren().add(bt);

    bp.setTop(lb1);
    bp.setCenter(ta);
    bp.setBottom(hb);

    bt.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 500, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      Pattern pn = Pattern.compile(tf1.getText());
      Matcher mt = pn.matcher(ta.getText());
      ta.setText(mt.replaceAll(tf2.getText()));
    }
  }
}
