package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
import model.picture.Point;
import model.picture.ShapeCreator;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements Command, Undoable {

  private UserChoices userChoices;
  private PaintCanvas paintCanvas;
  private Point start;
  private Point end;
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
    shape.paint(paintCanvas.getGraphics2D());
    CommandHistory.add(this);
  }


  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
