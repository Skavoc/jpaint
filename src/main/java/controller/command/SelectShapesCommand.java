package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;
import model.picture.Point;
import model.picture.ShapeSelection;
import view.gui.PaintCanvas;

public class SelectShapesCommand implements Command, Undoable {
  private PaintCanvas paintCanvas;
  private Point start;
  private Point end;
  private Drawable shape;

  private ArrayList<Drawable> PrevSelected = new ArrayList<>();


  public SelectShapesCommand(Point start, Point end) {
    this.start = start;
    this.end = end;
  }
  /**
   * Clears the list just incase there are any previous selections. Then adds the new selected shapes to a new list. Stores the prior selection, if any, in the event we need to go back to a prior shape selection.
   */
  @Override
  public void run() {
    if(!ListRepository.SelectedCollection.isEmpty())
      PrevSelected.addAll(ListRepository.SelectedCollection.getList());
    ListRepository.SelectedCollection.clear();
    ShapeSelection.select(start, end);
    CommandHistory.add(this);
  }
  /**
   * clears out the arraylist that contains the selected shapes. If there was a previous selection before this, then repopulate the selection with the previously selected shapes.
   */
  @Override
  public void undo() {
    ListRepository.SelectedCollection.clear();
    if(!PrevSelected.isEmpty())
      ListRepository.SelectedCollection.addAll(PrevSelected);
  }
  /**
   * Reselect the shapes that were previously selected.
   */
  @Override
  public void redo() {
    ListRepository.SelectedCollection.clear();
    ShapeSelection.select(start, end);
  }
}
