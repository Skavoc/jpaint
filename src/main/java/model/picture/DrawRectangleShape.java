package model.picture;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
/**
 * Creates the rectangle shape based on the User's choices. paint() Creates the shape on the canvas.
 */
public class DrawRectangleShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType ShadingType;
  private int Startx;
  private int Starty;
  private int width;
  private int height;
  private Rectangle2D r;

  public DrawRectangleShape(UserChoices userChoices, Point start, Point end){
    this.primaryColor = userChoices.getActivePrimaryColor().value;
    this.secondaryColor = userChoices.getActiveSecondaryColor().value;
    this.ShadingType = userChoices.getActiveShapeShadingType();
    this.Startx = Math.min(start.getX(), end.getX());
    this.Starty = Math.min(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX());
    this.height = Math.abs(start.getY()- end.getY());
  }

  @Override
  public void paint(Graphics2D graphics2d) {
    this.r = new Rectangle2D.Double(Startx, Starty, width, height);
    Stroke outline = new BasicStroke(6f);
    if (this.ShadingType == ShapeShadingType.OUTLINE){
      graphics2d.setColor(primaryColor);
      graphics2d.setStroke(outline);
      graphics2d.draw(this.r);
    }
    if (this.ShadingType == ShapeShadingType.FILLED_IN){
      graphics2d.setColor(primaryColor);
      graphics2d.fill(this.r);
    }
    if (this.ShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
      graphics2d.setColor(secondaryColor);
      graphics2d.setStroke(outline);
      graphics2d.draw(this.r);
      graphics2d.setColor(primaryColor);
      graphics2d.fill(this.r);
    }

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
    return this.r.intersects(Select);
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

  @Override
  public void selected() {

  }
}
