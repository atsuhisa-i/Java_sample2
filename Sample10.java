import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.collections.*;

public class Sample10 extends Application
{
  private ListView<String> lv;
  private Button bt;
  private ObservableList<String> ol;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    File fl = new File(".");
    File[] fls = fl.listFiles(new SampleFileFilter());
    String[] st = new String[fls.length];
    for(int i=0; i<fls.length; i++){
      st[i] = fls[i].getName();
    }
    ol = FXCollections.observableArrayList(st);

    lv = new ListView<String>(ol);
    bt = new Button("起動");
    
    BorderPane bp = new BorderPane();

    bp.setCenter(lv);
    bp.setBottom(bt);

    bt.setOnAction(new SampleEventHandler());

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
        java.awt.Desktop dp = java.awt.Desktop.getDesktop();
        dp.open(new File(lv.getSelectionModel().getSelectedItem()));
      }
      catch(IOException ex){
        System.out.println("起動できませんでした。");
      }
    }
  }

  class SampleFileFilter implements FileFilter
  {
    public boolean accept(File f)
    {
      if(f.isFile()){
        return true;
      }
      return false;
    }
  }
}