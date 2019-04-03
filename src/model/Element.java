package model;

import java.util.ArrayList;

public class Element implements CarComponent {
    @Override
    public boolean isItComposite() {
        return false;
    }

    @Override
    public void add(CarComponent component) {

    }

    @Override
    public void remove(CarComponent component) {

    }

    @Override
    public ArrayList<CarComponent> getChild() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
