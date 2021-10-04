package model.picture;

import model.ShapeType;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

/**
 * This will be the class that determines what shape is being created. Currently, only have the rectangle implemented.
 */
public class ShapeCreator {
  public static Drawable shapeCreate(UserChoices userChoices, Point start, Point end){
    Drawable shape = null;
    if (userChoices.getActiveShapeType() == ShapeType.RECTANGLE){
      shape = new DrawRectangleShape(userChoices, start, end);
    }
    return shape;
  }

}
