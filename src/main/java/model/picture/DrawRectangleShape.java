package model.picture;

import java.awt.*;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class DrawRectangleShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
  private int Startx;
  private int Starty;
  private int width;
  private int height;

  public DrawRectangleShape(UserChoices userChoices, Point start, Point end){
    this.primaryColor = userChoices.getActivePrimaryColor().value;
    this.secondaryColor = userChoices.getActiveSecondaryColor().value;
    this.Startx = Math.min(start.getX(), end.getX());
    this.Starty = Math.min(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX());
    this.height = Math.abs(start.getY()- end.getY());
  }

  @Override
  public void paint(Graphics2D graphics2d) {
    graphics2d.setColor(primaryColor);
    graphics2d.fillRect(Startx, Starty, width, height);

  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
