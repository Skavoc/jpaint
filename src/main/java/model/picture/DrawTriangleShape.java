package model.picture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class DrawTriangleShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType ShadingType;
  private int StartX;
  private int StartY;
  private int width;
  private int height;
  private int[] x;
  private int[] y;
  private Polygon p;

  public DrawTriangleShape(UserChoices userChoices, Point start, Point end){
    this.primaryColor = userChoices.getActivePrimaryColor().value;
    this.secondaryColor = userChoices.getActiveSecondaryColor().value;
    this.ShadingType = userChoices.getActiveShapeShadingType();
    this.StartX = Math.min(start.getX(), end.getX());
    this.StartY = Math.min(start.getY(), end.getY());
    int EndX = Math.max(start.getX(), end.getX());
    int EndY = Math.max(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX())*2;
    this.height = Math.abs(start.getY()- end.getY());
    int OppX;
    if (EndX < this.StartX){
      OppX = EndX + this.width;
    }
    else{
      OppX = EndX - this.width;
    }
    this.x = new int[]{StartX, EndX, OppX};
    this.y = new int[]{StartY, EndY, EndY};

  }

  @Override
  public void paint(Graphics2D graphics2d) {
    this.p = new Polygon(x,y, 3);
    Stroke outline = new BasicStroke(6f);
    if (this.ShadingType == ShapeShadingType.OUTLINE){
      graphics2d.setColor(primaryColor);
      graphics2d.setStroke(outline);
      graphics2d.draw(this.p);
    }
    if (this.ShadingType == ShapeShadingType.FILLED_IN){
      graphics2d.setColor(primaryColor);
      graphics2d.fill(this.p);
    }
    if (this.ShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
      graphics2d.setColor(secondaryColor);
      graphics2d.setStroke(outline);
      graphics2d.draw(this.p);
      graphics2d.setColor(primaryColor);
      graphics2d.fill(this.p);
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
    return this.p.intersects(Select);
  }
  /**
   * Easy shifts. Works with negative or positive shifts
   */
  @Override
  public void addX(int shift) {
    for(int i=0; i<3; i++)
      this.x[i] += shift;
  }

  @Override
  public void addY(int shift) {
    for(int i=0; i<3; i++)
      this.y[i] += shift;
  }

  @Override
  public void selected() {

  }

}
