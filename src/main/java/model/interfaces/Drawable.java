package model.interfaces;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Interface for shapes. Allows for abstraction.
 */
public interface Drawable {

  void paint(Graphics2D graphics2d);
  int getWidth();
  int getHeight();
  boolean intersect(Rectangle2D Select);
  void addX(int shift);
  void addY(int shift);
  void selected();

}
