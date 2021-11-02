package model.interfaces;

import java.awt.Color;

import model.ShapeShadingType;
import model.ShapeType;

public interface ShapeParameters {
  void store(UserChoices userChoices);
  ShapeType getShapeType();
  Color getPrimaryColor();
  Color getSecondaryColor();
  ShapeShadingType getShadingType();
}
