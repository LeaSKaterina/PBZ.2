package View.Table;

import Model.Plant;
import Model.Watering;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class PlantTable  extends TableView {
    final private TableColumn<Plant, Integer> idTableColumn;
    final private TableColumn<Plant, String> dateTableColumn;
    final private TableColumn<Plant, Short> ageTableColumn;
    final private TableColumn<Plant, String> typeTableColumn;
    final private TableColumn<Plant, Watering> wateringTableColumn;


    public PlantTable(){
        setMinHeight(600);

        idTableColumn = new TableColumn<>("ID");
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTableColumn.setPrefWidth(100);

        dateTableColumn = new TableColumn<>("Дата высадки");
        //ПРОБЛЕМА!!!!
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("plantingDate"));
        dateTableColumn.setPrefWidth(200);

        ageTableColumn = new TableColumn<>("Возраст");
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageTableColumn.setPrefWidth(100);

        typeTableColumn = new TableColumn<>("Тип");
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeTableColumn.setPrefWidth(200);

        wateringTableColumn = new TableColumn<>("Режим полива");
        wateringTableColumn.setCellValueFactory(new PropertyValueFactory<>("watering"));
        wateringTableColumn.setPrefWidth(400);

        getColumns().addAll(idTableColumn, dateTableColumn, ageTableColumn, typeTableColumn, wateringTableColumn);
    }

    public TableColumn<Plant, Integer> getIdTableColumn() {
        return idTableColumn;
    }

    public TableColumn<Plant, String> getDateTableColumn() {
        return dateTableColumn;
    }

    public TableColumn<Plant, Short> getAgeTableColumn() {
        return ageTableColumn;
    }

    public TableColumn<Plant, String> getTypeTableColumn() {
        return typeTableColumn;
    }

    public TableColumn<Plant, Watering> getWateringTableColumn() {
        return wateringTableColumn;
    }
}
