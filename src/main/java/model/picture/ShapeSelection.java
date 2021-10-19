package model.picture;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import model.interfaces.Drawable;

public class ShapeSelection {
  public static ArrayList<Drawable> select(ArrayList<Drawable> painting, Point Start, Point end) {
    Rectangle2D r = SelectionRectangle(Start, end);
    ArrayList<Drawable> selection = new ArrayList<Drawable>();
    for(Drawable i: painting){
      if (i.intersect(r)){
        selection.add(i);
      }
    }
    return selection;
  }

  public static Rectangle2D SelectionRectangle(Point Start, Point end) {
    int StartX= Math.min(Start.getX(), end.getX());
    int StartY = Math.min(Start.getY(), end.getY());
    int width = Math.abs(Start.getX()- end.getX());
    int height = Math.abs(Start.getY()- end.getY());
    return new Rectangle2D.Double(StartX, StartY, width, height);
  }
}
