package controller;

import controller.command.CommandController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picture.Point;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {
  private CommandController commandController;
  public MouseHandler(CommandController commandController){
    this.commandController = commandController;
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
    commandController.onDraw(start, end);
  }
}
