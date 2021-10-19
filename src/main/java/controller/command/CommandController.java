package controller.command;


import controller.interfaces.Command;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;
/**
 * Controller Class that will hold and initialize future commands
 */
public class CommandController {
  private UserChoices userChoices;
  private PaintCanvas paintCanvas;
  private ArrayList<Drawable> painting;

  public CommandController(UserChoices userChoices, PaintCanvas paintCanvas, ArrayList<Drawable> painting){
    this.userChoices = userChoices;
    this.paintCanvas = paintCanvas;
    this.painting = painting;
  }
  public void onDraw(Point start, Point end){
    Command command = new CreateShapeCommand(userChoices, paintCanvas, painting, start, end);
    command.run();
  }
  public void onSelect(Point start, Point end){
    Command command = new SelectShapesCommand(painting, start, end);
    command.run();
  }
  public void onMove(Point start, Point end){
    Command command = new MoveShapesCommand(painting, start, end);
    command.run();
  }

}
