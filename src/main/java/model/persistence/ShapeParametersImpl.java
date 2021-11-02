package model.persistence;

import java.awt.Color;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ShapeParameters;
import model.interfaces.UserChoices;

public class ShapeParametersImpl implements ShapeParameters {
  private ShapeType ShapeType;
  private Color PrimaryColor;
  private Color SecondaryColor;
  private ShapeShadingType ShapeShadingType;
  @Override
  public void store(UserChoices userChoices) {
    this.ShapeType = userChoices.getActiveShapeType();
    this.PrimaryColor = userChoices.getActivePrimaryColor().value;
    this.SecondaryColor =  userChoices.getActiveSecondaryColor().value;
    this.ShapeShadingType = userChoices.getActiveShapeShadingType();
  }
  @Override
  public ShapeType getShapeType(){
    return this.ShapeType;
  }
  @Override
  public Color getPrimaryColor(){
    return this.PrimaryColor;
  }
  @Override
  public Color getSecondaryColor(){
    return this.PrimaryColor;
  }
  @Override
  public ShapeShadingType getShadingType(){
    return this.ShapeShadingType;
  }
}
