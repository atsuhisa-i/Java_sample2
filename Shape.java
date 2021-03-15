import java.io.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

abstract class Shape implements Serializable
{
  static final int RECT = 0;
  static final int OVAL = 1;
  static final int LINE = 2;

  double x1, y1, x2, y2;
  double r, g, b;

  abstract public void draw(GraphicsContext gc);

  public void setColor(double r, double g, double b)
  {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  public void setStartPoint(double x, double y)
  {
    x1 = x; y1 = y;
  }
  public void setEndPoint(double x, double y)
  {
    x2 = x; y2 = y;
  }
}
class Rect extends Shape implements Serializable
{
  public void draw(GraphicsContext gc)
  {
    gc.setFill(Color.color(r, g, b));
    gc.fillRect(x1, y1, x2-x1, y2-y1);
  }
}
class Oval extends Shape implements Serializable
{
  public void draw(GraphicsContext gc)
  {
    gc.setFill(Color.color(r, g, b));
    gc.fillOval(x1, y1, x2-x1, y2-y1);
  }
}
class Line extends Shape implements Serializable
{
  public void draw(GraphicsContext gc)
  {
    gc.setStroke(Color.color(r, g, b));
    gc.strokeLine(x1, y1, x2, y2);
  }
}