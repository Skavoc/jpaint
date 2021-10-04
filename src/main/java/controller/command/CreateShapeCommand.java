package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
import model.picture.Point;
import model.picture.ShapeCreator;
import view.gui.PaintCanvas;
/**
 * Command that creates the shape and adds it to a list when run() is called.
 */
public class CreateShapeCommand implements Command, Undoable {

  private UserChoices userChoices;
  private PaintCanvas paintCanvas;
  private Point start;
  private Point end;
  private Drawable shape;
  private ArrayList<Drawable> painting;



  public CreateShapeCommand(UserChoices userChoices, PaintCanvas paintCanvas, ArrayList<Drawable> painting, Point start, Point end){
    this.userChoices = userChoices;
    this.paintCanvas = paintCanvas;
    this.painting = painting;
    this.start = start;
    this.end = end;

  }
  @Override
  public void run() {
    shape = ShapeCreator.shapeCreate(userChoices, start, end);
    painting.add(shape);
    paintCanvas.repaint();
    CommandHistory.add(this);
  }

  /**
   * Removes the shape from the list and calls repaint.
   */
  @Override
  public void undo() {
    painting.remove(shape);
    paintCanvas.repaint();
  }
  /**
   * Adds the shape back the list and calls repaint.
   */
  @Override
  public void redo() {
    painting.add(shape);
    paintCanvas.repaint();

  }
}
