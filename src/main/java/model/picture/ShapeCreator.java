package model.picture;

import model.ShapeType;
import model.interfaces.Drawable;
import model.interfaces.ShapeParameters;
import model.interfaces.UserChoices;
import model.persistence.ShapeParametersImpl;

/**
 * This will be the class that determines what shape is being created. Currently, only have the rectangle, ellipse and triangle implemented.
 */
public class ShapeCreator {
  public static Drawable shapeCreate(UserChoices userChoices, Point start, Point end){
    ShapeParameters settings = new ShapeParametersImpl();
    settings.store(userChoices);

    Drawable shape = null;
    ShapeType Type = settings.getShapeType();
    if (Type == ShapeType.RECTANGLE){
      shape = new DrawRectangleShape(settings, start, end);
    }
    if (Type == ShapeType.ELLIPSE){
      shape = new DrawEllipseShape(settings, start, end);
    }
    if (Type == ShapeType.TRIANGLE){
      shape = new DrawTriangleShape(settings, start, end);
    }
    return shape;
  }

}
