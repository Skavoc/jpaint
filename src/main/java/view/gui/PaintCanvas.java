package view.gui;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.*;
import model.interfaces.Drawable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {
    private ArrayList<Drawable> painting;
    private Drawable shape;
    public PaintCanvas(ArrayList painting){
        this.painting = painting;
    }

    private static final Logger log = LoggerFactory.getLogger(PaintCanvas.class);

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire model.picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paintComponent(Graphics graphics) {
      Graphics2D graphics2d = (Graphics2D) graphics;
      for (Drawable i : painting){
        i.paint(graphics2d);
      }

    }
}
