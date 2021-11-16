package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.Drawable;
import model.picture.MoveShape;
import model.picture.Point;
import view.gui.PaintCanvas;

public class MoveShapesCommand implements Command, Undoable {

  private final PaintCanvas paintCanvas;
  private final Point Start;
  private final Point End;

  public MoveShapesCommand(PaintCanvas paintCanvas, Point start, Point end) {
    this.paintCanvas = paintCanvas;
    this.Start = start;
    this.End =  end;
  }
  /**
   * Calls the move function and then the repaint function to show new positions after shift.
   */
  @Override
  public void run() {
    MoveShape.Move(Start, End);
    paintCanvas.repaint();
    CommandHistory.add(this);
  }
  /**
   * Undo is pretty simple in just swapping the start and end point which cancels out the move
   */
  @Override
  public void undo() {
    MoveShape.Move(End, Start);
    paintCanvas.repaint();
  }
  /**
   * Redo just does the move all over again
   */
  @Override
  public void redo() {
    MoveShape.Move(Start, End);
    paintCanvas.repaint();
  }
}
