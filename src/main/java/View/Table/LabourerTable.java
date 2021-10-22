package View.Table;

import Model.Labourer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LabourerTable extends TableView {

    final private TableColumn<Labourer, Short> idTableColumn;
    final private TableColumn<Labourer, String> lastNameTableColumn;
    final private TableColumn<Labourer, String> firstNameTableColumn;
    final private TableColumn<Labourer, String> patronymicTableColumn;
    final private TableColumn<Labourer, String> phoneTableColumn;
    final private TableColumn<Labourer, String> addressTableColumn;

    public LabourerTable() {
        setMinHeight(850);

        idTableColumn = new TableColumn<>("ID");
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        lastNameTableColumn = new TableColumn<>("Фамилия");
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameTableColumn.setPrefWidth(150);

        firstNameTableColumn = new TableColumn<>("Имя");
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameTableColumn.setPrefWidth(150);

        patronymicTableColumn = new TableColumn<>("Отчество");
        patronymicTableColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        patronymicTableColumn.setPrefWidth(150);

        phoneTableColumn = new TableColumn<>("Телефон");
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneTableColumn.setPrefWidth(150);

        addressTableColumn = new TableColumn<>("Адресс");
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressTableColumn.setPrefWidth(200);

        getColumns().addAll(idTableColumn, lastNameTableColumn, firstNameTableColumn, patronymicTableColumn, phoneTableColumn, addressTableColumn);
    }

    public TableColumn<Labourer, Short> getIdTableColumn() {
        return idTableColumn;
    }

    public TableColumn<Labourer, String> getLastNameTableColumn() {
        return lastNameTableColumn;
    }

    public TableColumn<Labourer, String> getFirstNameTableColumn() {
        return firstNameTableColumn;
    }

    public TableColumn<Labourer, String> getPatronymicTableColumn() {
        return patronymicTableColumn;
    }

    public TableColumn<Labourer, String> getPhoneTableColumn() {
        return phoneTableColumn;
    }

    public TableColumn<Labourer, String> getAddressTableColumn() {
        return addressTableColumn;
    }

}
