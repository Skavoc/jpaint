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
  private ArrayList<Drawable> selection;
  private Point Start;
  private Point End;

  public MoveShapesCommand(ArrayList<Drawable> selection, PaintCanvas paintCanvas, Point start, Point end) {
    this.paintCanvas = paintCanvas;
    this.selection = selection;
    this.Start = start;
    this.End =  end;
  }

  @Override
  public void run() {
    MoveShape.Move(selection, Start, End);
    paintCanvas.repaint();
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    MoveShape.Move(selection, End, Start);
    paintCanvas.repaint();
  }

  @Override
  public void redo() {
    MoveShape.Move(selection, Start, End);
    paintCanvas.repaint();
  }
}
