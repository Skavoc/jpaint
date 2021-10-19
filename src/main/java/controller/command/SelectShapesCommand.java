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
  private ArrayList<Drawable> PrevSelected = new ArrayList<>();


  public SelectShapesCommand(ArrayList<Drawable> painting, ArrayList<Drawable> selected, Point start, Point end) {
    this.painting = painting;
    this.start = start;
    this.end = end;
    this.selected = selected;
  }
  /**
   * Clears the list just incase there are any previous selections. Then adds the new selected shapes to a new list. Stores the prior selection, if any, in the event we need to go back to a prior shape selection.
   */
  @Override
  public void run() {
    if(!selected.isEmpty())
      PrevSelected.addAll(selected);
    this.selected.clear();
    ShapeSelection.select(painting, selected, start, end);
    CommandHistory.add(this);
  }
  /**
   * clears out the arraylist that contains the selected shapes. If there was a previous selection before this, then repopulate the selection with the previously selected shapes.
   */
  @Override
  public void undo() {
    this.selected.clear();
    if(!PrevSelected.isEmpty())
      selected.addAll(PrevSelected);
  }
  /**
   * Reselect the shapes that were previously selected
   */
  @Override
  public void redo() {
    ShapeSelection.select(painting, selected, start, end);
  }
}
