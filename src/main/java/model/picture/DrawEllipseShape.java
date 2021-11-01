package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class DrawEllipseShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType ShadingType;
  private int Startx;
  private int Starty;
  private int width;
  private int height;
  private Shape el;
  private Boolean Selected = false;

  public DrawEllipseShape(UserChoices userChoices, Point start, Point end){
    this.primaryColor = userChoices.getActivePrimaryColor().value;
    this.secondaryColor = userChoices.getActiveSecondaryColor().value;
    this.ShadingType =  userChoices.getActiveShapeShadingType();
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
  /**
   * Keeping it simple since we are already using awt for shape creation. Awt already has an intersect feature. No need to recreate the wheel.
   */
  @Override
  public boolean intersect(Rectangle2D Select) {
    return this.el.intersects(Select);
  }
  /**
   * Easy shifts. Works with negative or positive shifts
   */
  @Override
  public void addX(int shift) {
    this.Startx += shift;
  }

  @Override
  public void addY(int shift) {
    this.Starty += shift;
  }
}
