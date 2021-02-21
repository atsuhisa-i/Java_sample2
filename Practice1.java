import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;
import java.time.*;
import java.time.format.*;

public class Practice1 extends Application
{
  private Label lb;
  private ListView<String> lv;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");
    lv = new ListView<String>();

    ObservableList<String> ol =
      FXCollections.observableArrayList();
    
    DateTimeFormatter df = 
      DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime t = LocalDateTime.now();

    for(int i=0; i<50; i++){
      ol.add(df.format(t.plusDays(i)));
    }
    lv.setItems(ol);

    BorderPane bp = new BorderPane();

    bp.setTop(lb);
    bp.setCenter(lv);

    lv.getSelectionModel().selectedItemProperty().addListener(new SampleChangeListener());

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleChangeListener implements ChangeListener<String>
  {
    public void changed(ObservableValue ob, String bs, String as)
    {
      lb.setText(as + "ですね。");
    }
  }
}