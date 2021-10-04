package model.interfaces;

import java.awt.Graphics2D;

public interface Drawable {

  void paint(Graphics2D graphics2d);
  int getWidth();
  int getHeight();

}
