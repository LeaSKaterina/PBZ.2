package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Park {
    private Integer id;
    private String name;
    private final ObservableList<Zone> listOfZones = FXCollections.observableArrayList();
    private final ObservableList<Labourer> listOfLabourers = FXCollections.observableArrayList();
    private final ObservableList<Decorator> listOfDecorators = FXCollections.observableArrayList();
    private final Timetable timetable = new Timetable();

    public Park(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addZone(Zone zone){
        listOfZones.add(zone);
    }

    public void removeZone(String name){
        for (Zone zone: listOfZones){
            if (zone.getName().equals(name)){
                listOfZones.remove(zone);
                break;
            }
        }
    }

/*
    public void editZone(String name){
        for (Zone zone: listOfZones){
            if (zone.getName().equals(name)){
                zone.edit();
                break;
            }
        }
        System.out.println("Зоны с заданным названием не найдено");
    }
*/

}
