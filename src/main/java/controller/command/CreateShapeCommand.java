package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.UserChoices;
import model.picture.Point;

public class CreateShapeCommand implements Command, Undoable {

  private UserChoices userChoices;
  private Point start;
  private Point end;


  public CreateShapeCommand(UserChoices userChoices, Point start, Point end){
    this.userChoices = userChoices;
    this.start = start;
    this.end = end;

  }
  @Override
  public void run() {


  }


  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
