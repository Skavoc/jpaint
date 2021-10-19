package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;

public class DrawTriangleShape implements Drawable {
  private Color primaryColor;
  private Color secondaryColor;
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
    graphics2d.setColor(primaryColor);
    this.p = new Polygon(x,y, 3);
    graphics2d.fillPolygon(p);
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
    return this.p.intersects(Select);
  }

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

}
