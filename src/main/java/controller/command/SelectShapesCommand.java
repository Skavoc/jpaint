package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.Drawable;
import model.picture.Point;
import model.picture.ShapeSelection;
import view.gui.PaintCanvas;

public class SelectShapesCommand implements Command, Undoable {
  private PaintCanvas paintCanvas;
  private Point start;
  private Point end;
  private Drawable shape;
  private ArrayList<Drawable> painting;
  private ArrayList<Drawable> selected;


  public SelectShapesCommand(ArrayList<Drawable> painting, Point start, Point end) {
    this.painting = painting;
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {
    this.selected = ShapeSelection.select(painting, start, end);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    this.selected.clear();
  }

  @Override
  public void redo() {
    ShapeSelection.select(painting, start, end);
  }
}
