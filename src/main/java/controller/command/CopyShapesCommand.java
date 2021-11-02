package controller.command;

import controller.interfaces.Command;
import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;

public class CopyShapesCommand implements Command {
  private final ArrayList<Drawable> Selected = ListRepository.SelectedCollection.getList();
  /**
   * creates a copy and stores it in the copied list.
   */
  @Override
  public void run() {
    Drawable copy;
    ListRepository.CopiedShapeCollection.clear();
    for(Drawable i : Selected){
      copy = i.copy();
      ListRepository.CopiedShapeCollection.add(copy);
    }
    }
  }
