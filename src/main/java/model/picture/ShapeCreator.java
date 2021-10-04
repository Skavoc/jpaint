package model.picture;

import model.ShapeType;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class ShapeCreator {
  public static Drawable shapeCreate(UserChoices userChoices, Point start, Point end){
    Drawable shape = null;
    if (userChoices.getActiveShapeType() == ShapeType.RECTANGLE){
      shape = new DrawRectangleShape(userChoices, start, end);
    }
    return shape;
  }

}
