import java.io.*;
import java.util.regex.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample9 extends Application
{
  private Label lb;
  private TextArea ta;
  private TextField tf;
  private Button bt1, bt2;
  private Matcher mt;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("入力して下さい。");
    ta = new TextArea();
    tf = new TextField();
    bt1 = new Button("検索");
    bt2 = new Button("次へ");

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

    hb.getChildren().add(tf);
    hb.getChildren().add(bt1);
    hb.getChildren().add(bt2);

    bp.setTop(lb);
    bp.setCenter(ta);
    bp.setBottom(hb);

    bt1.setOnAction(new SampleEventHandler());
    bt2.setOnAction(new SampleEventHandler());

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      try{
        if(e.getSource() == bt1){
          Pattern pn = Pattern.compile(tf.getText());
          mt = pn.matcher(ta.getText());
          if(mt.find() != false){
            ta.selectRange(mt.start(), mt.end());
          }
          else{
            ta.home();
          }
        }
        else if(e.getSource() == bt2){
          if(mt.find() != false && mt.pattern().pattern().equals(tf.getText())){
            ta.selectRange(mt.start(), mt.end());
          }
        }
      }
      catch(Exception ex){
        ex.printStackTrace();
      }
    }
  }
}