package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;
import view.gui.PaintCanvas;

public class DeleteShapesCommand implements Command, Undoable {
  private final ArrayList<Drawable> Deleted = new ArrayList<Drawable>();
  private final PaintCanvas paintCanvas;
  public DeleteShapesCommand(PaintCanvas paintCanvas) {
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void run() {
    ArrayList<Drawable> Selected = ListRepository.SelectedCollection.getList();
    ArrayList<Drawable> Canvas = ListRepository.CanvasCollection.getList();
    if(!Selected.isEmpty()){
      Deleted.addAll(Selected);
      Canvas.removeAll(Selected);
      CommandHistory.add(this);
      paintCanvas.repaint();
    }
  }

  @Override
  public void undo() {
    ListRepository.CanvasCollection.addAll(Deleted);
    paintCanvas.repaint();
  }

  @Override
  public void redo() {
    ListRepository.CanvasCollection.removeAll(Deleted);
    paintCanvas.repaint();
  }
}
