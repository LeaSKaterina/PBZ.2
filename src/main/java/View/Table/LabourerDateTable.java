package View.Table;

import Model.LabourerDate;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class LabourerDateTable extends TableView {
    final private TableColumn<LabourerDate, String> lastNameTableColumn;
    final private TableColumn<LabourerDate, String> firstNameTableColumn;
    final private TableColumn<LabourerDate, String> patronymicTableColumn;
    final private TableColumn<LabourerDate, Date> dateTableColumn;
    final private TableColumn<LabourerDate, String> phoneTableColumn;

    public LabourerDateTable() {
        setMinHeight(850);

        lastNameTableColumn = new TableColumn<>("Фамилия");
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameTableColumn.setPrefWidth(150);

        firstNameTableColumn = new TableColumn<>("Имя");
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameTableColumn.setPrefWidth(150);

        patronymicTableColumn = new TableColumn<>("Отчество");
        patronymicTableColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        patronymicTableColumn.setPrefWidth(150);

        dateTableColumn = new TableColumn<>("Дата");
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateTableColumn.setPrefWidth(150);

        phoneTableColumn = new TableColumn<>("Телефон");
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneTableColumn.setPrefWidth(150);


        getColumns().addAll(lastNameTableColumn, firstNameTableColumn, patronymicTableColumn, dateTableColumn, phoneTableColumn);
    }


    public TableColumn<LabourerDate, String> getLastNameTableColumn() {
        return lastNameTableColumn;
    }

    public TableColumn<LabourerDate, String> getFirstNameTableColumn() {
        return firstNameTableColumn;
    }

    public TableColumn<LabourerDate, String> getPatronymicTableColumn() {
        return patronymicTableColumn;
    }

    public TableColumn<LabourerDate, Date> getDateTableColumn() { return dateTableColumn; }

    public TableColumn<LabourerDate, String> getPhoneTableColumn() {
        return phoneTableColumn;
    }

}
