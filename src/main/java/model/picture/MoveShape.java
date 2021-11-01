package model.picture;

import java.util.ArrayList;
import model.ListRepository.ListRepository;
import model.interfaces.Drawable;

public class MoveShape {

  public static void Move(Point Start, Point End) {
    int ShiftX = End.getX() - Start.getX();
    int ShiftY =  End.getY() - Start.getY();
    ArrayList<Drawable> selected = ListRepository.SelectedCollection.getList();
    for(Drawable i : selected){
      i.addX(ShiftX);
      i.addY(ShiftY);
    }
  }
}
