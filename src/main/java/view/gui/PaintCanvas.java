package view.gui;

import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.*;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {
    /**public PaintCanvas(ArrayList<Drawable> painting){
        this.painting = painting;
    }**/

    private static final Logger log = LoggerFactory.getLogger(PaintCanvas.class);

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }


    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire model.picture.
     * If you want to force a paint event, call aPaintCanvas.repaint()
     */
    @Override
    public void paintComponent(Graphics graphics) {
      ArrayList<Drawable> Canvas = ListRepository.CanvasCollection.getList();

      Graphics2D graphics2d = (Graphics2D) graphics;
      for (Drawable i : Canvas){
        i.paint(graphics2d);
      }

    }
}
