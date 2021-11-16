package model.picture;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.interfaces.Drawable;
import model.interfaces.ShapeParameters;
import model.interfaces.UserChoices;
/**
 * Creates the rectangle shape based on the User's choices. paint() Creates the shape on the canvas.
 */
public class DrawRectangleShape implements Drawable {

  private final Point Start;
  private final Point End;
  private final Color primaryColor;
  private final Color secondaryColor;
  private final ShapeShadingType ShadingType;
  private final ShapeParameters settings;
  private int Startx;
  private int Starty;
  private final int width;
  private final int height;
  private Rectangle2D r;
  private Graphics2D g;

  public DrawRectangleShape(ShapeParameters settings, Point start, Point end){
    this.primaryColor = settings.getPrimaryColor();
    this.secondaryColor = settings.getSecondaryColor();
    this.ShadingType = settings.getShadingType();
    this.settings = settings;
    this.Start = start;
    this.End = end;
    this.Startx = Math.min(start.getX(), end.getX());
    this.Starty = Math.min(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX());
    this.height = Math.abs(start.getY()- end.getY());
  }

  @Override
  public void paint(Graphics2D graphics2d) {
    g = graphics2d;
    this.r = new Rectangle2D.Double(Startx, Starty, width, height);
    Stroke outline = new BasicStroke(6f);
    if (this.ShadingType == ShapeShadingType.OUTLINE){
      g.setColor(primaryColor);
      g.setStroke(outline);
      g.draw(this.r);
    }
    if (this.ShadingType == ShapeShadingType.FILLED_IN){
      g.setColor(primaryColor);
      g.fill(this.r);
    }
    if (this.ShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
      g.setColor(secondaryColor);
      g.setStroke(outline);
      g.draw(this.r);
      g.setColor(primaryColor);
      g.fill(this.r);
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
  /**
   * run the selected method which draws an outline around the selected shape.
   */
  @Override
  public void selected() {
    Rectangle2D highlight = new Rectangle2D.Double(Startx, Starty-4, width+8, height+8);
    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g.setColor(Color.BLACK);
    g.setStroke(dashed);
    g.draw(highlight);
  }
  /**
   * creates a new shape which is a direct copy of the current shape state.
   */
  @Override
  public Drawable copy() {
    Drawable copy = new DrawRectangleShape(this.settings, this.Start, this.End);
    return copy;
  }

}
