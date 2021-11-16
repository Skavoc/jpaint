package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
import model.picture.Point;
import model.picture.ShapeCreator;
import view.gui.PaintCanvas;
/**
 * Command that creates the shape and adds it to a list when run() is called.
 */
public class CreateShapeCommand implements Command, Undoable {

  private final UserChoices userChoices;
  private final PaintCanvas paintCanvas;
  private final Point start;
  private final Point end;
  private Drawable shape;



  public CreateShapeCommand(UserChoices userChoices, PaintCanvas paintCanvas, Point start, Point end){
    this.userChoices = userChoices;
    this.paintCanvas = paintCanvas;
    this.start = start;
    this.end = end;

  }
  @Override
  public void run() {
    shape = ShapeCreator.shapeCreate(userChoices, start, end);
    ListRepository.CanvasCollection.add(shape);
    paintCanvas.repaint();
    CommandHistory.add(this);
  }

  /**
   * Removes the shape from the list and calls repaint.
   */
  @Override
  public void undo() {
    ListRepository.CanvasCollection.remove(shape);
    paintCanvas.repaint();
  }
  /**
   * Adds the shape back the list and calls repaint.
   */
  @Override
  public void redo() {
    ListRepository.CanvasCollection.add(shape);
    paintCanvas.repaint();

  }
}
