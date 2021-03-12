import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Practice1 extends Application
{
  private Label lb;
  private TextArea ta;
  private Button bt1, bt2;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("ファイルを選択して下さい。");
    ta = new TextArea();
    bt1 = new Button("読込");
    bt2 = new Button("保存");

    BorderPane bp = new BorderPane();
    HBox hb = new HBox();

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
      FileChooser fc = new FileChooser();
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("javaファイル", "*.java"));
      if(e.getSource() == bt1){
        try{
          File flo = fc.showOpenDialog(new Stage());
          if(flo != null){
            BufferedReader br = new BufferedReader(new FileReader(flo));
            StringBuffer sb = new StringBuffer();
            String str = null;
            while((str = br.readLine()) != null){
              sb.append(str + "\n");
            }
            ta.setText(sb.toString());
            br.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
      }
      else if(e.getSource() == bt2){
        try{
          File fls = fc.showSaveDialog(new Stage());
          if(fls !=null){
            BufferedWriter bw = new BufferedWriter(new FileWriter(fls));
            String str = ta.getText();
            bw.write(str);
            bw.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
      }
    }
  }
}