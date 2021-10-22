package View.Table;

import Model.Company;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CompanyTable extends TableView {
    final private TableColumn<Company, String> nameTableColumn;
    final private TableColumn<Company, String> addressTableColumn;

    public CompanyTable(){
        setMinHeight(600);

        nameTableColumn = new TableColumn<>("Название");
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameTableColumn.setPrefWidth(300);

        addressTableColumn = new TableColumn<>("Адрес фирмы");
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressTableColumn.setPrefWidth(300);

        getColumns().addAll(nameTableColumn, addressTableColumn);
    }

    public TableColumn<Company, String> getNameTableColumn() {
        return nameTableColumn;
    }

    public TableColumn<Company, String> getAddressTableColumn() {
        return addressTableColumn;
    }
}
