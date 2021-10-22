package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Company {
    private String name;
    private String address;
    private final ObservableList<Park> listOfParks = FXCollections.observableArrayList();

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addPark(Park park){
        listOfParks.add(park);
    }



}
