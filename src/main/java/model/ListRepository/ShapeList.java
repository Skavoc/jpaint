package model.ListRepository;

import java.util.ArrayList;
import model.interfaces.Drawable;
/**
 * Singleton list that creates one list and then modifies it when called on.
 */
public class ShapeList {
  private final ArrayList<Drawable> shapeList = new ArrayList<>();

  public void add(Drawable shape) {

    if (!shapeList.contains(shape)) {
      shapeList.add(shape);
    }
  }

  public Drawable get(int index) {

    return shapeList.get(index);
  }

  public void remove(Drawable item) {
    shapeList.remove(item);
  }

  public void clear() {
    shapeList.clear();
  }

  public boolean isEmpty() {
    return shapeList.isEmpty();
  }

  public ArrayList<Drawable> getList() {
    return shapeList;
  }

  public void addAll(ArrayList<Drawable> list) {
    shapeList.addAll(list);
  }
  public void removeAll(ArrayList<Drawable> list){
    shapeList.removeAll(list);
  }

}
