package model.interfaces;

import java.awt.Graphics2D;

/**
 * Interface for shapes. Allows for abstraction.
 */
public interface Drawable {

  void paint(Graphics2D graphics2d);
  int getWidth();
  int getHeight();

}
