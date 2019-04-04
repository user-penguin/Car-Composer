package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.CarComponent;
import model.Element;

public class Controller {
    private Element baseComponent;
    private Element currentElement;

    @FXML
    private TextField newName, nameLevel;

    @FXML
    private ListView<CarComponent> componentsView;

    private ObservableList<CarComponent> components;

    @FXML
    public void initialize() {
        baseComponent = new Element();
        baseComponent.add(new Element("Автомобиль"));
        currentElement = baseComponent;
        components = FXCollections.observableArrayList(baseComponent.getChild());
        componentsView.setItems(components);
    }

    @FXML
    public void addNew() {
        Element element = new Element(newName.getText());
        currentElement.add(element);
        componentsView.setItems(FXCollections.observableArrayList(currentElement.getChild()));
    }

    @FXML
    public void addLevel() {
        Element element = new Element(nameLevel.getText());
        CarComponent selectElement = componentsView.getSelectionModel().getSelectedItem();
        selectElement.add(element);
    }

    @FXML
    public void goInside() {
        if (componentsView.getSelectionModel().getSelectedItem().getChild().size() == 0) {
            System.out.println("Уровень пустой");
            return;
        }
        CarComponent selectElement = componentsView.getSelectionModel().getSelectedItem();
        currentElement = (Element) selectElement;
        componentsView.setItems(FXCollections.observableArrayList(selectElement.getChild()));
    }

    @FXML
    public void goOutside() {
        if (currentElement.getParent() == null) {
            System.out.println("Это корень, выше нельзя");
        } else {
            componentsView.setItems(FXCollections.observableArrayList(currentElement.getParent().getChild()));
            currentElement = (Element) currentElement.getParent();
        }
    }

}
