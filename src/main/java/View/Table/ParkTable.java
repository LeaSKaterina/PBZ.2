package View.Table;

import Model.Company;
import Model.Park;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ParkTable  extends TableView {
    final private TableColumn<Park, Integer> idTableColumn;
    final private TableColumn<Park, String> nameTableColumn;

    public ParkTable(){
        setMinHeight(600);

        idTableColumn = new TableColumn<>("ID");
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTableColumn.setPrefWidth(100);

        nameTableColumn = new TableColumn<>("Название");
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameTableColumn.setPrefWidth(500);

        getColumns().addAll(idTableColumn, nameTableColumn);
    }

    public TableColumn<Park, Integer> getIdTableColumn() {
        return idTableColumn;
    }

    public TableColumn<Park, String> getNameTableColumn() {
        return nameTableColumn;
    }
}
