package model.picture;

import model.ShapeType;
import model.interfaces.UserChoices;

public class ShapeCreate {
  private UserChoices userChoices;
  private Point DrawPoint;

  public ShapeCreate(UserChoices userChoices, Point start, Point end){
    int x = Math.min(start.getX(), end.getX());
    int y = Math.max(start.getY(), end.getY());
    Point drawPoint =  new Point(x,y);
    if (userChoices.getActiveShapeType() == ShapeType.RECTANGLE){
      DrawRectangle(userChoices, drawPoint);
    }
  }

}
