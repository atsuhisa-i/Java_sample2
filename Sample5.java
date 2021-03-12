import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample5 extends Application
{
  private Label lb;
  private TextField tf[] = new TextField[5];
  private Button bt1, bt2;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("整数を入力して下さい。");
    bt1 = new Button("読込");
    bt2 = new Button("保存");

    for(int i=0; i<tf.length; i++){
      String num = (Integer.valueOf(i)).toString();
      tf[i] = new TextField(num);
    }

    BorderPane bp = new BorderPane();
    HBox hb1 = new HBox();

    for(int i=0; i<tf.length; i++){
      hb1.getChildren().add(tf[i]);
    }

    HBox hb2 = new HBox();
    hb2.getChildren().add(bt1);
    hb2.getChildren().add(bt2);

    bp.setTop(lb);
    bp.setCenter(hb1);
    bp.setBottom(hb2);

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
      FileChooser fc = new FileChooser();
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("バイナリファイル", "*.bin"));
      if(e.getSource() == bt1){
        try{
          File flo = fc.showOpenDialog(new Stage());
          if(flo != null){
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(flo));
            for(int i=0; i<tf.length; i++){
              int num = bis.read();
              tf[i].setText(
                (Integer.valueOf(num)).toString());
            }
            bis.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
      }
      else if(e.getSource() == bt2){
        try{
          File fls = fc.showSaveDialog(new Stage());
          if(fls != null){
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fls));
            for(int i=0; i<tf.length; i++){
              int num = Integer.parseInt(tf[i].getText());
              bos.write(num);
            }
            bos.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
      }
    }
  }
}