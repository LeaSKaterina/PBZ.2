package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Zone {

    private String name;
    private ObservableList<Plant> listOfPlants = FXCollections.observableArrayList();
    private Integer plantCounter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlant(Plant plant){
        plantCounter++;
        plant.init(plantCounter);
        listOfPlants.add(plant);
    }

    public void removePlant(Short id){
        for (Plant plant : listOfPlants){
            if (plant.getId().equals(id)){
                listOfPlants.remove(plant);
                break;
            }
        }
        System.out.println("Растения с заданным id не найдено.");
    }

    public void edit(){}
}
