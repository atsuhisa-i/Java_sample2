import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.beans.property.*;

public class Sample3 extends Application
{
  private Label lb;
  private TableView<RowData> tv;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    lb = new Label("いらっしゃいませ。");
    tv = new TableView<RowData>();

    TableColumn<RowData, String> tc1 = 
      new TableColumn<RowData, String>("車名");
    TableColumn<RowData, String> tc2 = 
      new TableColumn<RowData, String>("価格");
    TableColumn<RowData, String> tc3 = 
      new TableColumn<RowData, String>("月日");
    
    tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("name"));
    tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("price"));
    tc3.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));

    ObservableList<RowData> ol = FXCollections.observableArrayList();
    ol.add(new RowData("乗用車", 1200, "10-01"));
    ol.add(new RowData("トラック", 2400, "10-05"));
    ol.add(new RowData("オープンカー", 3600, "10-06"));
    ol.add(new RowData("タクシー", 2500, "10-10"));
    ol.add(new RowData("スポーツカー", 2600, "10-11"));
    ol.add(new RowData("ミニカー", 300, "10-12"));
    ol.add(new RowData("自転車", 800, "10-15"));
    ol.add(new RowData("三輪車", 600, "10-18"));
    ol.add(new RowData("飛行機", 15000, "10-19"));
    ol.add(new RowData("乗用車", 1200, "10-01"));
    ol.add(new RowData("ヘリコプター", 3500, "10-21"));

    tv.getColumns().add(tc1);
    tv.getColumns().add(tc2);
    tv.getColumns().add(tc3);

    tv.setItems(ol);

    BorderPane bp = new BorderPane();

    bp.setTop(lb);
    bp.setCenter(tv);

    Scene sc = new Scene(bp, 300, 200);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }
  public class RowData
  {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty price;
    private final SimpleStringProperty date;

    public RowData(String n, Integer p, String d)
    {
      this.name = new SimpleStringProperty(n);
      this.price = new SimpleIntegerProperty(p);
      this.date = new SimpleStringProperty(d);
    }
    public StringProperty nameProperty(){return name;}
    public IntegerProperty priceProperty(){return price;}
    public StringProperty dateProperty(){return date;}
  }
}