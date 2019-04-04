package model;

import java.util.ArrayList;

public class Element implements CarComponent {
    private ArrayList<CarComponent> childs;
    private String name;
    private CarComponent parent;

    public Element() {
        childs = new ArrayList<>();
        parent = null;
    }

    public Element(String name) {
        childs = new ArrayList<>();
        parent = null;
        this.name = name;
    }


    @Override
    public boolean isItComposite() {
        if (childs.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void add(CarComponent component) {
        component.setParent(this);
        childs.add(component);
    }

    @Override
    public void remove(CarComponent component) {
        childs.remove(component);
    }

    @Override
    public ArrayList<CarComponent> getChild() {
        return childs;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    // метод должен быть переопределён в наследнике
    public String getInfo() {
        return null;
    }

    @Override
    public CarComponent getParent() {
        return parent;
    }

    @Override
    public void setParent(CarComponent component) {
        this.parent = component;
    }

    @Override
    public String toString() {
        return name;
    }
}
