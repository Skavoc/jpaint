package model.picture;

import java.awt.*;
import model.interfaces.UserChoices;

public class DrawRectangleShape {
  private Color primaryColor;
  private Color secondaryColor;
  private int Startx;
  private int Starty;
  private int width;
  private int height;

  public DrawRectangleShape(UserChoices userChoices, Point drawPoint){
    this.primaryColor = userChoices.getActivePrimaryColor().value;
    this.secondaryColor = userChoices.getActiveSecondaryColor().value;
    this.Startx = Math.min(start.getX(), end.getX());
    this.Starty = Math
  }

}
