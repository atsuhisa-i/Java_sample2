import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.event.*;

public class Sample extends Application
{
  private MenuBar mb;
  private Menu[] mn = new Menu[3];
  private MenuItem[] mi = new MenuItem[2];
  private RadioMenuItem[] rmi = new RadioMenuItem[3];
  private ToggleGroup tg;
  private ColorPicker cp;
  private Canvas cv;
  private ToolBar tb;
  private ArrayList<Shape> shapeList;
  private int currentShape;
  private Color currentColor;
  private double x1, x2, y1, y2;

  public static void main(String[] args)
  {
    launch(args);
  }
  public void start(Stage stage)throws Exception
  {
    cv = new Canvas(600, 340);
    mb = new MenuBar();
    cp = new ColorPicker();
    tb = new ToolBar();

    mn[0] = new Menu("ファイル");
    mn[1] = new Menu("設定");
    mn[2] = new Menu("図形");

    mi[0] = new MenuItem("開く");
    mi[1] = new MenuItem("保存");

    rmi[0] = new RadioMenuItem("四角形");
    rmi[1] = new RadioMenuItem("楕円");
    rmi[2] = new RadioMenuItem("直線");

    mn[0].getItems().add(mi[0]);
    mn[0].getItems().add(mi[1]);

    mn[1].getItems().add(mn[2]);

    mn[2].getItems().add(rmi[0]);
    mn[2].getItems().add(rmi[1]);
    mn[2].getItems().add(rmi[2]);

    mb.getMenus().add(mn[0]);
    mb.getMenus().add(mn[1]);

    tb.getItems().add(cp);

    tg = new ToggleGroup();
    rmi[0].setToggleGroup(tg);
    rmi[1].setToggleGroup(tg);
    rmi[2].setToggleGroup(tg);

    BorderPane bp = new BorderPane();

    bp.setTop(mb);
    bp.setCenter(cv);
    bp.setBottom(tb);

    for(int i=0; i<mi.length; i++)
    {
      mi[i].setOnAction(new SampleEventHandler());
    }
    for(int i=0; i<rmi.length; i++)
    {
      rmi[i].setOnAction(new SampleEventHandler());
    }
    cp.setOnAction(new SampleEventHandler());

    cv.addEventHandler(MouseEvent.MOUSE_PRESSED,
      (new SampleMouseEventHandler()));
    cv.addEventHandler(MouseEvent.MOUSE_RELEASED,
      (new SampleMouseEventHandler()));
    
    shapeList = new ArrayList<Shape>();
    currentShape = Shape.RECT;
    currentColor = Color.BLUE;
    cp.setValue(currentColor);
    rmi[0].setSelected(true);
    x1=-1; y1=-1; x2=-1; y2=-1;

    Scene sc = new Scene(bp, 600, 400);

    stage.setScene(sc);

    stage.setTitle("サンプル");
    stage.show();
  }

  class SampleEventHandler implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource() == mi[0]){
        try{
          FileChooser fc = new FileChooser();
          fc.getExtensionFilters().add(
            new FileChooser.ExtensionFilter(
              "グラフィックファイル", "*.g"));
          File flo = fc.showOpenDialog(new Stage());
          if(flo !=null){
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(flo));
            Shape tmp = null;
            shapeList.clear();
            while((tmp = (Shape)oi.readObject())
              != null){
                shapeList.add(tmp);
              }
              oi.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.clearRect(0, 0, 600, 340);
        for(int i=0; i < shapeList.size(); i++){
          Shape sh = (Shape) shapeList.get(i);
          sh.draw(gc);
        }
      }
      else if(e.getSource() == mi[1]){
        try{
          FileChooser fc = new FileChooser();
          fc.getExtensionFilters().add(
            new FileChooser.ExtensionFilter(
              "グラフィックファイル", "*.g"));
          File fls = fc.showSaveDialog(new Stage());
          if(fls != null){
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(fls));
            for(int i=0; i<shapeList.size(); i++){
              oo.writeObject(shapeList.get(i));
            }
            oo.writeObject(null);
            oo.close();
          }
        }
        catch(Exception ex){
          ex.printStackTrace();
        }
      }
      else if(e.getSource() == rmi[0]){
        currentShape = Shape.RECT;
      }
      else if(e.getSource() == rmi[1]){
        currentShape = Shape.OVAL;
      }
      else if(e.getSource() == rmi[2]){
        currentShape = Shape.LINE;
      }
      else if(e.getSource() == cp){
        currentColor = cp.getValue();
      }
    }
  }
  class SampleMouseEventHandler implements EventHandler<MouseEvent>
  {
    public void handle(MouseEvent e)
    {
      if(e.getEventType() == MouseEvent.MOUSE_PRESSED){
        x1 = e.getX();
        y1 = e.getY();
      }
      else if(e.getEventType() == MouseEvent.MOUSE_RELEASED){
        x2 = e.getX(); y2 = e.getY();

        if(x1 < 0 || y1 < 0 || (x1 == x2 && y1 == y2))
          return;
        
        Shape sh = null;
        if(currentShape == Shape.RECT){
          sh = new Rect();
        }
        else if(currentShape == Shape.OVAL){
          sh = new Oval();
        }
        else if(currentShape == Shape.LINE){
          sh = new Line();
        }

        double r = currentColor.getRed();
        double g = currentColor.getGreen();
        double b = currentColor.getBlue();
        sh.setColor(r, g, b);

        if(currentShape != Shape.LINE){
          if(x1 > x2){
            x2 = x1;
            x1 = e.getX();
          }
          if(y1 > y2){
            y2 = y1;
            y1 = e.getY();
          }
        }
        sh.setStartPoint(x1, y1);
        sh.setEndPoint(x2, y2);

        shapeList.add(sh);

        GraphicsContext gc = cv.getGraphicsContext2D();
        sh.draw(gc);
      }
    }
  }
}