package controller;

import controller.command.CommandController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.MouseMode;
import model.interfaces.UserChoices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.picture.Point;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {
  private final CommandController commandController;
  private final UserChoices userChoices;
  public MouseHandler(CommandController commandController, UserChoices userChoices){
    this.commandController = commandController;
    this.userChoices = userChoices;
  }

  private static final Logger log = LoggerFactory.getLogger(MouseHandler.class);
  private Point start;
  private Point end;

  @Override
  public void mousePressed(MouseEvent e) {
    start = new Point(e.getX(),e.getY());
    log.debug("Start " + e.getX() + " " + e.getY());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    end = new Point(e.getX(), e.getY());
    log.debug("End " + e.getX() + " " + e.getY());
    if(userChoices.getActiveMouseMode() == MouseMode.DRAW) {
      commandController.onDraw(start, end);
    }
    if(userChoices.getActiveMouseMode() == MouseMode.MOVE){
      commandController.onMove(start, end);
    }
    if(userChoices.getActiveMouseMode() == MouseMode.SELECT){
      commandController.onSelect(start, end);
    }
  }
}
