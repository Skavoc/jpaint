package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class DrawEllipseShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
  private int Startx;
  private int Starty;
  private int width;
  private int height;
  private Shape el;

  public DrawEllipseShape(UserChoices userChoices, Point start, Point end){
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
    this.el = new Ellipse2D.Double(Startx, Starty, width, height);
    graphics2d.fill(this.el);
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public boolean intersect(Rectangle2D Select) {
    return this.el.intersects(Select);
  }
}
