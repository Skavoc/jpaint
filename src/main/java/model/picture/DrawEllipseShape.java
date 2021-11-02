package model.picture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.interfaces.Drawable;
import model.interfaces.ShapeParameters;
import model.interfaces.UserChoices;

public class DrawEllipseShape implements Drawable {

  private final Point Start;
  private final Point End;
  private final ShapeParameters settings;
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType ShadingType;
  private int Startx;
  private int Starty;
  private int width;
  private int height;
  private Shape el;
  private Boolean Selected = false;
  private Graphics2D g;

  public DrawEllipseShape(ShapeParameters settings, Point start, Point end){
    this.primaryColor = settings.getPrimaryColor();
    this.secondaryColor = settings.getSecondaryColor();
    this.ShadingType =  settings.getShadingType();
    this.Start = start;
    this.End = end;
    this.settings = settings;
    this.Startx = Math.min(start.getX(), end.getX());
    this.Starty = Math.min(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX());
    this.height = Math.abs(start.getY()- end.getY());
  }
  @Override
  public void paint(Graphics2D graphics2d) {
    this.g = graphics2d;
    this.el = new Ellipse2D.Double(Startx, Starty, width, height);
    Stroke outline = new BasicStroke(6f);
    if (this.ShadingType == ShapeShadingType.OUTLINE){
      g.setColor(primaryColor);
      g.setStroke(outline);
      g.draw(this.el);
    }
    if (this.ShadingType == ShapeShadingType.FILLED_IN){
      g.setColor(primaryColor);
      g.fill(this.el);
    }
    if (this.ShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
      g.setColor(secondaryColor);
      g.setStroke(outline);
      g.draw(this.el);
      g.setColor(primaryColor);
      g.fill(this.el);
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

  /**
   * run the selected method which draws an outline around the selected shape.
   */
  @Override
  public void selected() {
    Shape highlight = new Ellipse2D.Double(Startx-6, Starty-6, width+6, height+6);
    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g.setColor(Color.black);
    g.setStroke(dashed);
    g.draw(highlight);
  }
  /**
   * creates a new shape which is a direct copy of the current shape state.
   */
  @Override
  public Drawable copy() {
    Drawable copy = new DrawEllipseShape(this.settings, this.Start, this.End);
    return copy;
  }
}
