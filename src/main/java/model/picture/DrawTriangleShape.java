package model.picture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import model.ShapeShadingType;
import model.interfaces.Drawable;
import model.interfaces.ShapeParameters;

public class DrawTriangleShape implements Drawable {

  private int EndX;
  private int EndY;
  private int OppX;
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType ShadingType;
  private Point Start;
  private Point End;
  private ShapeParameters settings;
  private int StartX;
  private int StartY;
  private int width;
  private int height;
  private int[] x;
  private int[] y;
  private Polygon p;
  private Graphics2D g;

  public DrawTriangleShape(ShapeParameters settings, Point start, Point end){
    this.primaryColor = settings.getPrimaryColor();
    this.secondaryColor = settings.getSecondaryColor();
    this.ShadingType = settings.getShadingType();
    this.settings = settings;
    this.Start = start;
    this.End = end;

    this.StartX = Math.min(start.getX(), end.getX());
    this.StartY = Math.min(start.getY(), end.getY());
    this.EndX = Math.max(start.getX(), end.getX());
    this.EndY = Math.max(start.getY(), end.getY());
    this.width = Math.abs(start.getX()- end.getX())*2;
    this.height = Math.abs(start.getY()- end.getY());
    this.OppX = 0;
    if (EndX < this.StartX){
      this.OppX = EndX + this.width;
    }
    else{
      this.OppX = EndX - this.width;
    }
    this.x = new int[]{StartX, EndX, OppX};
    this.y = new int[]{StartY, EndY, EndY};

  }

  @Override
  public void paint(Graphics2D graphics2d) {
    this.g = graphics2d;
    this.p = new Polygon(x,y, 3);
    Stroke outline = new BasicStroke(6f);
    if (this.ShadingType == ShapeShadingType.OUTLINE){
      g.setColor(primaryColor);
      g.setStroke(outline);
      g.draw(this.p);
    }
    if (this.ShadingType == ShapeShadingType.FILLED_IN){
      g.setColor(primaryColor);
      g.fill(this.p);
    }
    if (this.ShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
      g.setColor(secondaryColor);
      g.setStroke(outline);
      g.draw(this.p);
      g.setColor(primaryColor);
      g.fill(this.p);
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
    this.StartX += shift;
    this.EndX += shift;
    this.OppX += shift;

  }

  @Override
  public void addY(int shift) {
    for(int i=0; i<3; i++)
      this.y[i] += shift;
    this.StartY += shift;
    this.EndY += shift;
  }
  /**
   * run the selected method which draws an outline around the selected shape.
   */
  @Override
  public void selected() {
    int[] shiftX= new int[]{StartX-4, EndX+4, OppX-4};
    int[] shiftY= new int[]{StartY,EndY+4,EndY+4};
    Polygon highlight = new Polygon(shiftX,shiftY,3);
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
    Drawable copy = new DrawTriangleShape(this.settings,this.Start,this.End);
    return copy;
  }

}
