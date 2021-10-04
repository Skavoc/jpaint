package controller.command;


import controller.interfaces.Command;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;

public class CommandController {
  private UserChoices userChoices;
  private PaintCanvas paintCanvas;
  private ArrayList painting;

  public CommandController(UserChoices userChoices, PaintCanvas paintCanvas, ArrayList painting){
    this.userChoices = userChoices;
    this.paintCanvas = paintCanvas;
    this.painting = painting;
  }
  public void onDraw(Point start, Point end){
    Command command = new CreateShapeCommand(userChoices, paintCanvas, painting, start, end);
    command.run();

  }

}
