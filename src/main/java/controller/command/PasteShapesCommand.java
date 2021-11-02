package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;
import model.picture.Point;
import view.gui.PaintCanvas;

public class PasteShapesCommand implements Command, Undoable {
  private ArrayList<Drawable> Copied = ListRepository.CopiedShapeCollection.getList();
  private ArrayList<Drawable> temp = new ArrayList<>();
  private PaintCanvas paintCanvas;

  public PasteShapesCommand(PaintCanvas paintCanvas) {
    this.paintCanvas = paintCanvas;
  }
  /**
   * performs a move on the copied shapes then adds them to the canvas collection to be painted when repaint() is called. Also creates a copy of the old spot but i need to work more on it to shift the prior locaiton.
   */
  @Override
  public void run() {
    Drawable pasted;
    for(Drawable i: Copied){
      i.addX(8);
      i.addY(8);
      temp.add(i);
    }
    ListRepository.CanvasCollection.addAll(temp);
    ListRepository.CopiedShapeCollection.clear();
    for(Drawable i: temp){
      pasted = i.copy();
      ListRepository.CopiedShapeCollection.add(pasted);
    }
    paintCanvas.repaint();
    CommandHistory.add(this);
  }
  /**
   * Remove everything from the temp list from the canvas
   */
  @Override
  public void undo() {
    ListRepository.CanvasCollection.removeAll(temp);
    paintCanvas.repaint();

  }
  /**
   * adds everything back from the temp list.
   */
  @Override
  public void redo() {
    ListRepository.CanvasCollection.addAll(temp);
    paintCanvas.repaint();
  }
}
