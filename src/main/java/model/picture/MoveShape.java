package model.picture;

import java.util.ArrayList;
import model.interfaces.Drawable;

public class MoveShape {

  public static void Move(ArrayList<Drawable> selected, Point Start, Point End) {
    int ShiftX = End.getX() - Start.getX();
    int ShiftY =  End.getY() - Start.getY();
    for(Drawable i : selected){
      i.addX(ShiftX);
      i.addY(ShiftY);
    }
  }
}
