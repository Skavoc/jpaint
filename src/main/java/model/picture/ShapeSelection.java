package model.picture;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import model.interfaces.Drawable;

public class ShapeSelection {
  public static void select(ArrayList<Drawable> painting,ArrayList<Drawable> selection, Point Start, Point end) {
    Rectangle2D r = SelectionRectangle(Start, end);
    for(Drawable i: painting){
      if (i.intersect(r)){
        selection.add(i);
      }
    }
  }
  /**
   * Creates a (for now) non-visible rectangle based off of the start and end point. This rectangle is used to check for intersection.
   */
  public static Rectangle2D SelectionRectangle(Point Start, Point end) {
    int StartX= Math.min(Start.getX(), end.getX());
    int StartY = Math.min(Start.getY(), end.getY());
    int width = Math.abs(Start.getX()- end.getX());
    int height = Math.abs(Start.getY()- end.getY());
    return new Rectangle2D.Double(StartX, StartY, width, height);
  }
}
