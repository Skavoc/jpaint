package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.UserChoices;
import picture.Point;

public class CreateShapeCommand implements Command, Undoable {

  private UserChoices userChoices;
  public CreateShapeCommand(UserChoices userChoices, Point start, Point end){

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
