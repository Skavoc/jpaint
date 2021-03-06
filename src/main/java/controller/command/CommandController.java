package controller.command;


import controller.interfaces.Command;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;
/**
 * Controller Class that will hold and initialize future commands
 */
public class CommandController {

  private final UserChoices userChoices;
  private final PaintCanvas paintCanvas;

  public CommandController(UserChoices userChoices, PaintCanvas paintCanvas){
    this.userChoices = userChoices;
    this.paintCanvas = paintCanvas;

  }
  public void onDraw(Point start, Point end){
    Command command = new CreateShapeCommand(userChoices, paintCanvas, start, end);
    command.run();
  }
  public void onSelect(Point start, Point end){
    Command command = new SelectShapesCommand(start, end);
    command.run();
    paintCanvas.repaint();
  }
  public void onMove(Point start, Point end){
    Command command = new MoveShapesCommand(paintCanvas, start, end);
    command.run();
  }
  public void onCopy(){
    Command command = new CopyShapesCommand();
    command.run();
  }
  public void onPaste(){
    Command command = new PasteShapesCommand(paintCanvas);
    command.run();
  }
  public void onDelete(){
    Command command = new DeleteShapesCommand(paintCanvas);
    command.run();
  }

}
