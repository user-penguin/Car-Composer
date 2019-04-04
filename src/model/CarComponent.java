package model;

import java.util.ArrayList;

public interface CarComponent {
    boolean isItComposite();

    void add(CarComponent component);

    void remove(CarComponent component);

    ArrayList<CarComponent> getChild();

    String getName();

    String getInfo();

    CarComponent getParent();

    void setParent(CarComponent component);
}
